package paulhise.picfeedlive;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import static paulhise.picfeedlive.MySharedPreferences.USERNAMEPREF;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// TODO NOTES:
// rewrite caption button needs logic
// camera request button needs to make camera request for result
// gallery request button needs to make gallery request for result
// set up onactivityresult to get photo from either source
// on activity needs to call methods to change visibilty of the 2 bottom buttons and the caption edittext field
// change visibilty of uplaod button to show after a caption has been set

// tie upload button to firebase
// set up async task for returning the image

public class CreateContentActivity extends AppCompatActivity {

    private static final String TAG = "CreateContentActivity: ";
    public static final int CAMERA_REQUEST = 1;
    public static final int GALLERY_REQUEST = 2;

    @BindView(R.id.edittext_caption) EditText mCaptionEditText;
    @BindView(R.id.textview_caption_preview) TextView mCaptionPreviewTextView;
    @BindView(R.id.textView_username) TextView mUserNameTextView;
    @BindView(R.id.imageview_create) ImageView mImageToPostImageView;

    String mUserNameString;
    String mCaptionPreviewString;
    Intent mMoveToPicFeed;
    Intent mMoveToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);

        initializer();
    }

    //
    // class methods //

    // OnCreate methods and variable initializers
    private void initializer() {
        ButterKnife.bind(this);
        setUserName();
        mMoveToPicFeed = new Intent(this, PicFeedActivity.class);
        mMoveToLogin = new Intent(this, LoginActivity.class);
    }

    private void setUserName(){
        mUserNameString = MySharedPreferences.getUserName(this);
        mUserNameTextView.setText(mUserNameString);
    }

    private void editCaption(){
        // Text field is invisible until picture is present to caption
        mCaptionEditText.setVisibility(View.VISIBLE);

        // actionListener for EditText field where users put there new user name
        mCaptionEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    mCaptionPreviewString = mCaptionEditText.getText().toString();
                    if (!isEmpty(mCaptionPreviewString)) {
                        mCaptionPreviewTextView.setText(mCaptionPreviewString);
                        clearEditTextField();
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void clearEditTextField(){
        mCaptionEditText.setText("");
        mCaptionEditText.setVisibility(View.INVISIBLE);
    }

    private void moveToPicFeed(){
        startActivity(mMoveToPicFeed);
    }

    private void moveToLogin(){
        startActivity(mMoveToLogin);
    }

    private boolean isEmpty(String string) {
        int stringLength = string.trim().length();
        return (stringLength <= 0);
    }

    //
    // butterknifed buttons //

    @OnClick(R.id.button_cancel_post)
    public void pressedCancelPost(){
        moveToPicFeed();
    }

    @OnClick(R.id.button_logout)
    public void pressedLogout(){
        moveToLogin();
    }

    @OnClick(R.id.button_gallery_request)
    public void pressedPhotoFromGallery(){
        //need to write gallery request code and delete editCaption
        editCaption();
    }

    @OnClick(R.id.button_camera_request)
    public void pressedPhotoFromCamera(){
        //need to write camera request logic

    }

//    @OnClick(R.id.button_create_post)
//    public void pressedShareThisPost(){
//        todo need to write post to firebase logic
//
//    }

    @OnClick(R.id.button_rewrite_caption)
    public void pressedRewriteCaption(){
        editCaption();
    }


}