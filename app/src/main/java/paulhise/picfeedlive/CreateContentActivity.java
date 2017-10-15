package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// create EditText input field to get the username from the user
// create upload button that will put user inputs in the database
// onActivityResult of posting content return to PicFeedActivity
// create cancel button that returns to the PicFeedActivity
// tie upload button to firebase
// set up a sync task for returning the image

public class CreateContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);
    }
}