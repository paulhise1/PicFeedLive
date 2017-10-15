package paulhise.picfeedlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class PicFeedActivity extends AppCompatActivity {

    private static final String TAG = "PicFeedActivity";

    private Button postButton;
    private Button logoutButton;
    private ListView feedListView;

    public ArrayList<FeedItem> testList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_feed);

        //need to give it the ArrayList<FeedItem> that is constructed from all the FeedItem's
        setupFeedListView();
    }

    // method that puts all the FeedItem's into the feedListView
    private void setupFeedListView(ArrayList<FeedItem> feedList){
        feedListView = (ListView) findViewById(R.id.list_pic_feed);

        FeedListAdapter feedAdapter = new FeedListAdapter(feedList);

        feedListView.setAdapter(feedAdapter);

    }

    // inner class creating custom list adapter for the feed list.
    // called by setupFeedListView
    class FeedListAdapter extends BaseAdapter {

        private ArrayList<FeedItem> feedItemsList;

        public FeedListAdapter(ArrayList<FeedItem> feedItemsList){
            super();
            this.feedItemsList = feedItemsList;
        }
        @Override
        public int getCount() {
            return feedItemsList.size();
        }
        @Override
        public Object getItem(int i) {
            return feedItemsList.get(i);
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            FeedItem currentItem = feedItemsList.get(i);

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

    // my test list in lieu of having a read list of FeedItem's
    private ArrayList<FeedItem> createTestArrayList(ArrayList<FeedItem> feedItemList) {
        ArrayList<FeedItem> newList = feedItemList;

        FeedItem test1 = new FeedItem("test 1", null, null);
        FeedItem test2 = new FeedItem("test 2", null, null);
        FeedItem test3 = new FeedItem("test 3", null, null);
        FeedItem test4 = new FeedItem("test 4", null, null);
        FeedItem test5 = new FeedItem("test 5", null, null);

        newList.add(test1);
        newList.add(test2);
        newList.add(test3);
        newList.add(test4);
        newList.add(test5);

        return newList;
    }

}
