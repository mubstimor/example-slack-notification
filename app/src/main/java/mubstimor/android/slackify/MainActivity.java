package mubstimor.android.slackify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SlackView {

    ProgressBar progressBar;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        btnSend = (Button) findViewById(R.id.btnSend);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final SlackView slackView = this;

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSend.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                String name = txtName.getText().toString();
                postSlackData(new SlackNotification(name), slackView);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * instantiate object to post message.
     * @param slackNotification message to send.
     */
    public void postSlackData(SlackNotification slackNotification, SlackView slackView) {
        SlackPresenter slackPresenter = new SlackPresenter();
        slackPresenter.postMessage(slackNotification, slackView);
    }

    @Override
    public void responseReady(String response) {
        TextView tvResponse = (TextView) findViewById(R.id.tvResponse);
        tvResponse.setText(response);
        progressBar.setVisibility(View.INVISIBLE);
        btnSend.setEnabled(true);
    }
}
