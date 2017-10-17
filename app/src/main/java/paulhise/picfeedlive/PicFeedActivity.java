package paulhise.picfeedlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

// setup logout button class, call that on logout button in this class
// finish createPostButton logic that takes app to CreateContentActivity

// obtain the list of FeedItemObject's from firebase realtime database

public class PicFeedActivity extends AppCompatActivity {

    private static final String TAG = "PicFeedActivity";

    private Button mCreatePostButton;
    private Button mLogoutButton;
    private Intent mGoToCreateContentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_feed);

        // initializing member variables
        mCreatePostButton = (Button) findViewById(R.id.button_post);
        mGoToCreateContentActivity = new Intent(this, CreateContentActivity.class);

        // !!! right now using TestArrayListObject class to test the listview
        TestArrayListObject testList;
        testList = new TestArrayListObject();

        // calling class methods
        setupFeedListView(testList.feedItemsTestListObject);
        attachOnClickListeners();

    }

    private void attachOnClickListeners(){

        mCreatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mGoToCreateContentActivity);
            }
        });


    }

    // method that puts all the FeedItemObject's into the feedListView using the custom adapter class FeedListAdapter
    private void setupFeedListView(ArrayList<FeedItemObject> feedList){
        ListView feedListView;

        feedListView = (ListView) findViewById(R.id.list_pic_feed);

        FeedListAdapter feedAdapter = new FeedListAdapter(feedList);

        feedListView.setAdapter(feedAdapter);

    }


    // inner class creating custom list adapter for the feed list.
    // with the getView doing all the heavy lifting of the adapter
    // called by setupFeedListView
    class FeedListAdapter extends BaseAdapter {

        private ArrayList<FeedItemObject> feedItemsListObject;

        public FeedListAdapter(ArrayList<FeedItemObject> feedItemsListObject){
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

}
