package mubstimor.android.slackify;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class to invoke post method.
 */
public class SlackPresenter {

    private SlackService slackService;

    /**
     * Initialises a service that connects to API endpoints.
     */
    public SlackPresenter() {
        if (this.slackService == null) {
            this.slackService = new SlackService();
        }
    }

    /**
     * post to webhook.
     *
     * @param slackNotification view to which response is mapped
     */
    public void postMessage(final SlackNotification slackNotification, final SlackView slackView) {

        slackService
                .getAPI()
                .postSlackMessage(slackNotification.toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(
                            Call<ResponseBody> call,
                            Response<ResponseBody> response
                    ) {
                        if (response.isSuccessful()) {
                            slackView.responseReady("message sent");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        slackView.responseReady("unable to send message");
                    }
                });
    }
}
