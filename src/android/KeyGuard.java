package com.vladstirbu.cordova;

import android.util.Log;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class KeyGuard extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        PluginResult result;

        if (action.equals("set")) {
            final Boolean enabled = args.optBoolean(0);
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    if (enabled) {
                        cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
                    } else {
                        cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
                    }

                    PluginResult result = new PluginResult(PluginResult.Status.OK);

                    callbackContext.sendPluginResult(result);
                };
            });
            return true;
        }
        else if (action.equals("enabled")) {
            int flags = cordova.getActivity().getWindow().getAttributes().flags;
            boolean status;

            if ((flags & WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD) != 0) {
                status = true;
            } else {
                status = false;
            }

            result = new PluginResult(PluginResult.Status.OK, status);

            callbackContext.sendPluginResult(result);
            return true;
        }

        result = new PluginResult(PluginResult.Status.INVALID_ACTION);

        callbackContext.sendPluginResult(result);

        return false;
    }
}
