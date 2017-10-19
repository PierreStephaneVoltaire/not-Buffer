package com.example.steph.socialappthingy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends AppCompatActivity {
    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_main);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);

        this.loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Toast.makeText(MainActivity.this, "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                // Do something with result, which provides a TwitterSession for making API calls
                //TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                //TwitterAuthToken authToken = session.getAuthToken();
                //String token = authToken.token;
                //  String secret = authToken.secret;
            }

            @Override
            public void failure(TwitterException exception) {
                // Make and alert to notify the user that i messed up
                Toast.makeText(MainActivity.this, "Authentication failed!", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        this.loginButton.onActivityResult(requestCode, resultCode, data);
    }


}
