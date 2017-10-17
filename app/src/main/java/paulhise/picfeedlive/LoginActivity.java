package paulhise.picfeedlive;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        // calling class methods
        setUpView();

    }

    private void setUpView(){
        // initiailizing member variables for setUpView method
        mSignInButton = (Button) findViewById(R.id.button_user_sign_in);
        mCreateUserButton = (Button) findViewById(R.id.button_create_user_login);
        mUserNameCreationInput = (EditText) findViewById(R.id.edit_text_username_input);

        mUserNameCreationInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    saveUsername();
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
                // write logic for mCreateUserButton
            }
        });
    }

    private void saveUsername(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
