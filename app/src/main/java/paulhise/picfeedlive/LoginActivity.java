package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// create EditText input field where users can enter their username.
// establish a shared preferences to store the user name in.
// create login button that will save the user's name and move activity to PicFeedActivity
// create a sign in button that will allow users to resign in

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
