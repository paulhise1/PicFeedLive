package paulhise.picfeedlive;

import android.graphics.Bitmap;

/**
 * Created by paulhise on 10/14/17.
 */

class FeedItem {

    String feedItemText;
    Bitmap userBitmap;
    Bitmap feedItemBitmap;

    // FeedItem Constructor
    public FeedItem(String s, Bitmap bmUser, Bitmap bmFeedItem){

        this.userBitmap = bmUser;
        this.feedItemText = s;
        this.feedItemBitmap = bmFeedItem;

    }
}
