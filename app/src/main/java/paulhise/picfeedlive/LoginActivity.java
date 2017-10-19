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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// create logic for the sign in button that will allow users to resign in
// will need to make a user field in firebase that will display to the users in a list and allow them to select thier previously entered username.

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity: ";

    @BindView(R.id.button_user_sign_in) Button mSignInButton;
    @BindView(R.id.button_create_user) Button mCreateUserButton;
    @BindView(R.id.edit_text_username_input) EditText mUserNameCreationInput;

    Intent mGoToPicFeedActivity;
    String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initializer();
        listenForEnter();

    }

    private void initializer() {
        mGoToPicFeedActivity = new Intent(this, PicFeedActivity.class);
    }

    private void listenForEnter() {
        // actionListener for EditText field where users put there new user name
        mUserNameCreationInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    setUserNamePref();
                    // checks to see if mUserName is empty.  If it is not Enter key
                    if (isEmpty(mUserName)) {
                        return true;

                    } else {
                        startActivity(mGoToPicFeedActivity);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private boolean isEmpty(String string) {
        int stringLength = string.trim().length();
        return (stringLength <= 0);
    }

    //
    // butterknifed buttons //

    @OnClick(R.id.button_user_sign_in)
    public void pressedSignIn(){

    }

    @OnClick(R.id.button_create_user)
    public void pressedCreateAccount() {
        setUserNamePref();
        if (!isEmpty(mUserName)) {
            startActivity(mGoToPicFeedActivity);
        }
    }
    //
    // helper methods //

    // grabs username text from EditText field
    private void setUserNamePref() {
        mUserName = mUserNameCreationInput.getText().toString();
        MySharedPreferences.setUserName(this, mUserName);
        dismissKeyboard();
    }

    // dismisses keyboard from screen
    private void dismissKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
