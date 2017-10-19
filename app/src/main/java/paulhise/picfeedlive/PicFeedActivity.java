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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static paulhise.picfeedlive.MySharedPreferences.USERNAMEPREF;



// obtain the list of FeedItemObject's from firebase realtime database

public class PicFeedActivity extends AppCompatActivity {

    private static final String TAG = "PicFeedActivity";

    @BindView(R.id.textView_username) TextView mUserNameTextView;
    @BindView(R.id.button_create_post) Button mCreatePostButton;
    @BindView(R.id.button_logout) Button mLogoutButton;

    Intent mGoToCreateContentActivity;
    Intent mGoToLoginActivity;;
    String mUserNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_feed);

        establishIntents();

        // !!! right now using TestArrayListObject class to test the listview
        TestArrayListObject testList;
        testList = new TestArrayListObject();

        // calling class methods
        ButterKnife.bind(this);
        setUserName();
        setupFeedListView(testList.feedItemsTestListObject);

    }

    private void establishIntents(){
        mGoToCreateContentActivity = new Intent(this, CreateContentActivity.class);
        mGoToLoginActivity = new Intent(this, LoginActivity.class);
    }

    // butterknifed methods establishing buttons

    @OnClick(R.id.button_create_post)
    public void moveToCreateContentActivity(){
        startActivity(mGoToCreateContentActivity);
    }

    @OnClick(R.id.button_logout)
    public void moveToLoginActivity(){
        startActivity(mGoToLoginActivity);
    }

    // method that puts all the FeedItemObject's into the feedListView using the custom adapter class FeedListAdapter
    private void setupFeedListView(ArrayList<FeedItemObject> feedList) {
        ListView feedListView;

        feedListView = (ListView) findViewById(R.id.list_pic_feed);

        FeedListAdapter feedAdapter = new FeedListAdapter(feedList);

        feedListView.setAdapter(feedAdapter);

    }


    // inner class creating custo  m list adapter for the feed list used in setupFeedListView
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
        mUserNameString = MySharedPreferences.getUserName(this);
        mUserNameTextView.setText(mUserNameString);
    }

}
