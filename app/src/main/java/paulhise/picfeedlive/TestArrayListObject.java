package paulhise.picfeedlive;

import java.util.ArrayList;

/**
 * Created by paulhise on 10/16/17.
 */

class TestArrayListObject {
    private static final String TAG = "TestArrayListObject: ";

    ArrayList<FeedItemObject> feedItemsTestListObject;

    public TestArrayListObject(){
        this.feedItemsTestListObject = createTestArrayList();
    }

    private ArrayList<FeedItemObject> createTestArrayList() {

        ArrayList<FeedItemObject> newList = new ArrayList<>();

        FeedItemObject test1 = new FeedItemObject("test 1", null, null);
        newList.add(test1);
        FeedItemObject test2 = new FeedItemObject("test 2", null, null);
        newList.add(test2);
        FeedItemObject test3 = new FeedItemObject("test 3", null, null);
        newList.add(test3);
        FeedItemObject test4 = new FeedItemObject("test 4", null, null);
        newList.add(test4);
        FeedItemObject test5 = new FeedItemObject("test 5", null, null);
        newList.add(test5);

        return newList;
    }

}
