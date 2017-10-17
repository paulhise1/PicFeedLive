package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// create EditText input field where users can enter their username.
// establish a shared preferences to store the user name in.
// create login button that will save the user's name and move activity to PicFeedActivity
// create a sign in button that will allow users to resign in

public class LoginActivity extends AppCompatActivity {

    private Button mSignInButton;
    private Button mCreateUserButton;
    private EditText mUserNameCreationInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // initializing member variables
        mSignInButton = (Button) findViewById(R.id.button_user_sign_in);
        mCreateUserButton = (Button) findViewById(R.id.button_create_user_login);
        mUserNameCreationInput = (EditText) findViewById(R.id.edit_text_username_input);

        // calling class methods
        attachOnClickListeners();


    }

    private void attachOnClickListeners(){

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write logic for mSignInButton
            }
        });

        mCreateUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write logic for mCreateUserButton
            }
        });

    }

}
