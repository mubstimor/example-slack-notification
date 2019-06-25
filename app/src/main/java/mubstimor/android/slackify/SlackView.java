package mubstimor.android.slackify;

public interface SlackView {
    /**
     * print results to screen.
     * @param response string to notify slack status
     */
    void responseReady(String response);
}
