package paulhise.picfeedlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


// camera request button needs to make camera request for result
// gallery request button needs to make gallery request for result
// set up onactivityresult to get photo from either source
// on activity needs to call methods to change visibilty of the 2 bottom buttons and the caption edittext field
// change visibilty of uplaod button to show after a caption has been set

// tie upload button to firebase
// set up async task for returning the image

public class CreateContentActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 1;
    public static final int GALLERY_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);


        setupView();
        attachOnClickListeners();

    }

    private void setupView(){

        // initializing views
        TextView mUserName;
        mUserName = (TextView) findViewById(R.id.textView_username);
        EditText mCaption;
        mCaption = (EditText) findViewById(R.id.edittext_caption);
        ImageView mImageToPost;
        mImageToPost = (ImageView) findViewById(R.id.imageview_create);

        // sets username field in top bar
        mUserName.setText(MySharedPreferences.getUserName(this));


    }

    private void attachOnClickListeners() {

        // initialize intents
        final Intent mGoToPicFeedActivity;
        final Intent mGoToLoginActivity;
        mGoToPicFeedActivity = new Intent(this, PicFeedActivity.class);
        mGoToLoginActivity = new Intent(this, LoginActivity.class);

        // initialize buttons with thier views
        Button mCancelButton;
        Button mLogoutButton;
        Button mCameraRequestButton;
        Button mGalleryRequestButton;
        Button mPostButton;
        mCancelButton = (Button) findViewById(R.id.button_cancel_post);
        mLogoutButton = (Button) findViewById(R.id.button_logout);
        mCameraRequestButton = (Button) findViewById(R.id.button_camera_request);
        mGalleryRequestButton = (Button) findViewById(R.id.button_gallery_request);
        mPostButton = (Button) findViewById(R.id.button_upload_post);

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mGoToPicFeedActivity);
            }
        });

        // log the user out before moving them back to the LoginActivity
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(mGoToLoginActivity);
            }
        });

        mCameraRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        mGalleryRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



}