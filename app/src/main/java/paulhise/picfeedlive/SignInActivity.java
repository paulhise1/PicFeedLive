package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;


// create new user button needs to have intent to go back to loginActivity
// setup list adapter that will take all the different useres and assing them to the custom view and fill in the users list
// logic for list that when a user is selected moves them to picFeedActivity with that profile signed in

public class SignInActivity extends AppCompatActivity {

    private Button mLoginButton;
    private ListView mUserListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


    }


}
