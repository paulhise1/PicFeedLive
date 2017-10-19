package paulhise.picfeedlive;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by paulhise on 10/17/17.
 */

public class MySharedPreferences {

    // initializing public variables for establishing username saved as a sharedpreference
    public static final String USERNAMEPREF = "userName";

    public static void setUserName(Context context, String name){
        // establishing sharedpreferences to give username to
        SharedPreferences mSharedPreferences;
        mSharedPreferences = context.getSharedPreferences(USERNAMEPREF, Context.MODE_PRIVATE);

        // allows edit of sharedprefrences
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USERNAMEPREF, name);
        editor.apply();
    }


    public static String getUserName(Context context){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(USERNAMEPREF, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(USERNAMEPREF, null);
    }

}
