package paulhise.picfeedlive;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static paulhise.picfeedlive.LoginActivity.MyPREFERENCES;

// obtain the list of FeedItemObject's from firebase realtime database

public class PicFeedActivity extends AppCompatActivity {

    private static final String TAG = "PicFeedActivity";

    private TextView mUserNameText;
    private Button mCreatePostButton;
    private Button mLogoutButton;
    private Intent mGoToCreateContentActivity;
    private Intent mGoToLoginActivity;
    private SharedPreferences mSharedPreferences;
    private String mUserNameDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_feed);

        // !!! right now using TestArrayListObject class to test the listview
        TestArrayListObject testList;
        testList = new TestArrayListObject();

        // calling class methods
        setupView();
        setUserName();
        setupFeedListView(testList.feedItemsTestListObject);
        attachOnClickListeners();

    }

    private void setupView(){
        mCreatePostButton = (Button) findViewById(R.id.button_create_post);
        mLogoutButton = (Button) findViewById(R.id.button_logout);
        mUserNameText = (TextView) findViewById(R.id.textView_username);

    }
    private void attachOnClickListeners() {

        mGoToCreateContentActivity = new Intent(this, CreateContentActivity.class);
        mGoToLoginActivity = new Intent(this, LoginActivity.class);


        mCreatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mGoToCreateContentActivity);
            }
        });

        // log the user out before moving them back to the LoginActivity
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(mGoToLoginActivity);
            }
        });
    }

    // method that puts all the FeedItemObject's into the feedListView using the custom adapter class FeedListAdapter
    private void setupFeedListView(ArrayList<FeedItemObject> feedList) {
        ListView feedListView;

        feedListView = (ListView) findViewById(R.id.list_pic_feed);

        FeedListAdapter feedAdapter = new FeedListAdapter(feedList);

        feedListView.setAdapter(feedAdapter);

    }


    // inner class creating custom list adapter for the feed list used in setupFeedListView
    class FeedListAdapter extends BaseAdapter {

        private ArrayList<FeedItemObject> feedItemsListObject;

        public FeedListAdapter(ArrayList<FeedItemObject> feedItemsListObject) {
            super();
            this.feedItemsListObject = feedItemsListObject;
        }

        @Override
        public int getCount() {
            return feedItemsListObject.size();
        }

        @Override
        public Object getItem(int i) {
            return feedItemsListObject.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            FeedItemObject currentItem = feedItemsListObject.get(i);

            view = getLayoutInflater().inflate(R.layout.picfeed_list_item_view, null);

            ImageView userImageView = (ImageView) view.findViewById(R.id.imageView_user);
            TextView feedTextView = (TextView) view.findViewById(R.id.textView_feed_text);
            ImageView feedImageView = (ImageView) view.findViewById(R.id.imageView_feed_image);

            userImageView.setImageBitmap(currentItem.userBitmap);
            feedTextView.setText(currentItem.feedItemText);
            feedImageView.setImageBitmap(currentItem.feedItemBitmap);

            return view;
        }
    }

    private void setUserName(){
        mUserNameDisplayText= MySharedPreferences.getUserName(this);
        mUserNameText.setText(mUserNameDisplayText);

    }

}
