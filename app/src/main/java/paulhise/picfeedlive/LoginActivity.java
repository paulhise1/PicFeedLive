package paulhise.picfeedlive;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// TODO NOTES:
// create logic for the sign in button that will allow users to resign in
// will need to make a user field in firebase that will display to the users in a list and allow them to select thier previously entered username.

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity: ";

    @BindView(R.id.button_user_sign_in) Button mSignInButton;
    @BindView(R.id.button_create_user) Button mCreateUserButton;
    @BindView(R.id.edit_text_username_input) EditText mUserNameCreationInput;

    Intent mMoveToPicFeed;
    String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializer();
    }

    //
    // class methods //

    // OnCreate methods and variable initializers
    private void initializer() {
        ButterKnife.bind(this);
        listenForEnter();
        mMoveToPicFeed = new Intent(this, PicFeedActivity.class);
    }

    // Logic for When 'Enter' is pressed on EditText field. Does the same thing as Create Account button does.
    private void listenForEnter() {
        // actionListener for EditText field where users put there new user name
        mUserNameCreationInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    setUserNamePref();
                    // checks to see if mUserName is empty.  If it is not Enter key
                    if (!isEmpty(mUserName)) {
                        moveToPicFeed();
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    // grabs username text from EditText field
    private void setUserNamePref() {
        mUserName = mUserNameCreationInput.getText().toString();
        MySharedPreferences.setUserName(this, mUserName);
        dismissKeyboard();
    }

    private void dismissKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void moveToPicFeed(){
        startActivity(mMoveToPicFeed);
    }

    private boolean isEmpty(String string) {
        int stringLength = string.trim().length();
        return (stringLength <= 0);
    }

    //
    // butterknifed buttons //

    // sign in button
    @OnClick(R.id.button_user_sign_in)
    public void pressedSignIn(){
        // todo: need to write sign in logic
    }

    // create account button
    @OnClick(R.id.button_create_user)
    public void pressedCreateAccount() {
        setUserNamePref();
        if (!isEmpty(mUserName)) {
            moveToPicFeed();
        }
    }


}
