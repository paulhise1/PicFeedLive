package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// create upload button that will put user inputs in the database
// onActivityResult of posting content return to PicFeedActivity
// create cancel button that returns to the PicFeedActivity

// tie upload button to firebase
// set up async task for returning the image

public class CreateContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);
    }
}