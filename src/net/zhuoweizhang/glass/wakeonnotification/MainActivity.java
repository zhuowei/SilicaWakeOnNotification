package net.zhuoweizhang.glass.wakeonnotification;

import java.io.*;
import java.util.*;

import android.app.*;
import android.os.*;
import android.content.*;
import android.content.pm.*;
import static android.content.pm.PackageManager.*;
import android.widget.Toast;

public class MainActivity extends Activity
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		PackageManager pm = getPackageManager();
		ComponentName receiverComponent = new ComponentName(this, NotificationReceiver.class);
		int curState = pm.getComponentEnabledSetting(receiverComponent);
		boolean isEnabledNow = (curState == COMPONENT_ENABLED_STATE_ENABLED); //defaults to disabled
		int newState = isEnabledNow? COMPONENT_ENABLED_STATE_DISABLED : COMPONENT_ENABLED_STATE_ENABLED;
		pm.setComponentEnabledSetting(receiverComponent, newState, DONT_KILL_APP);
		Toast.makeText(this, isEnabledNow? R.string.wake_disabled : R.string.wake_enabled, Toast.LENGTH_SHORT).show();
		finish();
	}



}
