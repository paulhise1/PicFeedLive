package paulhise.picfeedlive;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import static android.R.attr.start;
import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by paulhise on 10/18/17.
 */

public class LogoutClass {

    public static void logout(Context context) {

        Intent mGoToLoginActivity;
        mGoToLoginActivity = new Intent(context, LoginActivity.class);
        startActivity(context, mGoToLoginActivity, null);

    }

}
