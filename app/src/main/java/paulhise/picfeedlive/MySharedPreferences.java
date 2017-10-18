package paulhise.picfeedlive;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static paulhise.picfeedlive.LoginActivity.MyPREFERENCES;

/**
 * Created by paulhise on 10/17/17.
 */

public class MySharedPreferences {

    // initializing public variables for establishing username saved as a sharedpreference
    public static final String MyPREFERENCES = "userName";

    public static void setUserName(Context context, String name){

        // establishing sharedpreferences to give username to
        SharedPreferences mSharedPreferences;
        mSharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        // allows edit of sharedprefrences
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(MyPREFERENCES, name);
        editor.apply();
    }


    public static String getUserName(Context context){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(MyPREFERENCES, null);


    }
}
