package mubstimor.android.slackify;

/**
 * Model for body of message to be posted.
 */
public class SlackNotification {

    private String name;

    /**
     * constructor for model.
     * @param name string for user name
     */
    public SlackNotification(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String greeting = "{"
                + "'username': 'convergebot',"
                + "'text':'Hello " + name + ", "
                + "Have a good day!"
                + "' "
                + "}";
        return greeting;
    }
}
