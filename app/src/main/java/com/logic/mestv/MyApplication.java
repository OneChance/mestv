package com.logic.mestv;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MyApplication extends Application {

    private static Context context;
    public static Integer VERSION = 5;
    private static List<Activity> mList = new LinkedList();
    public static boolean netAble = true;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        //CrashHandler.getInstance().init(this);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static void toast(String msg, boolean success) {
        customToast(msg, success);
    }

    public static void toast(int resId, boolean success) {
        String msg = getResString(resId);
        customToast(msg, success);
    }

    public static void customToast(String msg, boolean success) {
        View toastView = LayoutInflater.from(context).inflate(R.layout.toast, null);
        Toast toast = new Toast(context);
        TextView textView = (TextView) toastView.findViewById(R.id.toast_notice);
        if (success) {
            textView.setBackgroundColor(context.getResources().getColor(R.color.success));
        } else {
            textView.setBackgroundColor(context.getResources().getColor(R.color.error));
        }
        textView.setText(msg);
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);

        toast.show();
    }

    public static String getResString(int resId) {
        return context.getResources().getString(resId);
    }

    public static void addActivity(Activity activity) {
        mList.add(activity);
    }

    public static void appSendBroadcast(String action) {
        Intent intent = new Intent(action);
        context.sendBroadcast(intent);
    }

    public static void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}