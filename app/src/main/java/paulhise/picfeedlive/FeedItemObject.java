package paulhise.picfeedlive;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by paulhise on 10/14/17.
 */

class FeedItemObject {

    String feedItemText;
    Bitmap userBitmap;
    Bitmap feedItemBitmap;

    // FeedItemObject Constructor
    public FeedItemObject(String s, Bitmap bmUser, Bitmap bmFeedItem){
        this.userBitmap = bmUser;
        this.feedItemText = s;
        this.feedItemBitmap = bmFeedItem;

    }

}
