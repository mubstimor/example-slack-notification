package mubstimor.android.slackify;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * instantiate retrofit instance.
 */
public class SlackService {

    private Retrofit retrofit = null;

    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public SlackApi getAPI() {
        String baseURL = "https://hooks.slack.com/";
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(baseURL)
                    .client(client)
                    .build();
        }
        return retrofit.create(SlackApi.class);
    }
}
