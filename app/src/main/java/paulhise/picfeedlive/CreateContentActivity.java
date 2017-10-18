package paulhise.picfeedlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

// rewrite caption button needs logic
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

    private String mCaptionString;
    private TextView mCaptionPreviewTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);

        setupView();
        attachOnClickListeners();

    }

    private void setupView(){

        // initializing views
        TextView mUserNameTextView;
        ImageView mImageToPostImageView;
        mUserNameTextView = (TextView) findViewById(R.id.textView_username);
        mImageToPostImageView = (ImageView) findViewById(R.id.imageview_create);

        // sets username field in top bar
        mUserNameTextView.setText(MySharedPreferences.getUserName(this));


    }

    private void editCaption(){

        final EditText mCaptionEditText;
        mCaptionEditText = (EditText) findViewById(R.id.edittext_caption);
        mCaptionEditText.setVisibility(View.VISIBLE);

        // actionListener for EditText field where users put there new user name
        mCaptionEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (mCaptionEditText.getText() != null) {
                        mCaptionPreviewTextView.setText(mCaptionEditText.getText().toString());
                        mCaptionEditText.setText("");
                        mCaptionEditText.setVisibility(View.INVISIBLE);
                    }

                    return true;
                }
                return false;
            }
        });


    }
    private void attachOnClickListeners() {

        // initialize intents
        final Intent mGoToPicFeedActivity;
        final Intent mGoToLoginActivity;
        mGoToPicFeedActivity = new Intent(this, PicFeedActivity.class);
        mGoToLoginActivity = new Intent(this, LoginActivity.class);

        // initialize buttons with their views
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

        // setup onclick listeners for the buttons
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
                editCaption();
            }
        });

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



}