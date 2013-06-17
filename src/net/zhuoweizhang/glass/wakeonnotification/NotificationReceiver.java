package net.zhuoweizhang.glass.wakeonnotification;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;

public class NotificationReceiver extends BroadcastReceiver {

	public static final String TAG = "SilicaWakeOnNotification";

	public static final long TIMEOUT = 5000; //5 seconds is long enough for anybody

	public void onReceive(Context context, Intent intent) {
		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE 
							| PowerManager.ACQUIRE_CAUSES_WAKEUP, TAG);
		wl.acquire(TIMEOUT); //FEAR FIRE FOES AWAKE
	}

}
