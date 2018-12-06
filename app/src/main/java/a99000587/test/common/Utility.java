package a99000587.test.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Utility {
	


	
	public static boolean isNetworkAvailable(Context context) {
		
		ConnectivityManager connectivity = null;
		boolean isNetworkAvail = false;
		
		try {
			connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				
				if (info != null) {
					for (NetworkInfo anInfo : info) {
						if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
							
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connectivity != null) {
				connectivity = null;
			}
		}
		return false;
	}
	

	
	private static ProgressDialog dialog;
	
	public static void showDailog(Context c, String msg) {
		dialog = new ProgressDialog(c);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setMessage(msg);
		dialog.show();
	}

	public static void closeDialog() {
		if (dialog != null)
			dialog.cancel();
	}
	

	


	
	
}
