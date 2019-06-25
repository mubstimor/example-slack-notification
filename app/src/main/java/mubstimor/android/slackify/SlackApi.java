package mubstimor.android.slackify;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Interface to define calls to api.
 */
public interface SlackApi {

    /**
     * post to channel.
     *
     * @param slackNotificationMessage string to send
     * @return body this is usually a string
     */
    @FormUrlEncoded
    @POST(BuildConfig.SLACKIFY_STATUS_HOOK)
    Call<ResponseBody> postSlackMessage(@Field("payload") String slackNotificationMessage);
}
