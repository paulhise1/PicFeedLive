package paulhise.picfeedlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// TODO NOTES:
// setup list adapter that will take all the different useres and assing them to the custom view and fill in the users list
// logic for list that when a user is selected moves them to picFeedActivity with that profile signed in

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.button_login) Button mLoginButton;
    @BindView(R.id.listview_user_list) ListView mUserListView;
    @BindView(R.id.textView_username) TextView mUserNameTextView;

    Intent mMoveToPicFeed;
    Intent mMoveToLogin;
    String mUserNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initializer();
    }

    //
    // class methods //

    // OnCreate methods and variable initializers
    private void initializer() {
        mMoveToLogin = new Intent(this, LoginActivity.class);
        mMoveToPicFeed = new Intent(this, PicFeedActivity.class);

        ButterKnife.bind(this);
        setUserName();
        setUserListView();

    }

    private void setUserName(){
        mUserNameString = MySharedPreferences.getUserName(this);
        mUserNameTextView.setText(mUserNameString);
    }

    private void setUserListView(){
        // todo logic putting list adapter into listview
    }

    // todo create inner class custom list adapter for user list

    //
    // butterknifed buttons //

    @OnClick(R.id.button_login)
    public void pressedCreateNewUser(){
        startActivity(mMoveToLogin);
    }

}
