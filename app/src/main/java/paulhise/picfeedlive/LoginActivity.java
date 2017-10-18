package paulhise.picfeedlive;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// create logic for the sign in button that will allow users to resign in
// will need to make a user field in firebase that will display to the users in a list and allow them to select thier previously entered username.

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity: ";

    // declaring member variables
    private EditText mUserNameCreationInput;
    private Intent mGoToPicFeedActivity;

    // initializing public variables for establishing username saved as a sharedpreference
    public static final String MyPREFERENCES = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // calling class methods
        setUpView();
        editSharedPreferences();

    }

    private void setUpView(){

        Button mSignInButton;
        Button mCreateUserButton;

        // setting views
        mSignInButton = (Button) findViewById(R.id.button_user_sign_in);
        mCreateUserButton = (Button) findViewById(R.id.button_create_user_login);
        mUserNameCreationInput = (EditText) findViewById(R.id.edit_text_username_input);

        // initializing variables
        mGoToPicFeedActivity = new Intent(this, PicFeedActivity.class);

        // actionListener for EditText field where users put there new user name
        mUserNameCreationInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    saveUsername();
                    startActivity(mGoToPicFeedActivity);
                    return true;
                }
                return false;
            }
        });

        // Button listeners and logic for buttons
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // write logic for mSignInButton
            }
        });

        mCreateUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUsername();
                startActivity(mGoToPicFeedActivity);
            }
        });
    }

    private void saveUsername(){
        // calls method that will put username in the sharedpreferences
        editSharedPreferences();

        //dismiss the keyboard from screen
        dismissKeyboard();

    }

    private void editSharedPreferences(){
        // grabs username text from EditText field
        String userName  = mUserNameCreationInput.getText().toString();

        MySharedPreferences.setUserName(this, userName);
    }

    private void dismissKeyboard(){
        // dismisses keyboard from screen
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
