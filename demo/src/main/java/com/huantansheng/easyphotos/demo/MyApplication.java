package com.huantansheng.easyphotos.demo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 主要用于检测内存泄漏
 * Created by huan on 2018/1/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        CrashReport.initCrashReport(getApplicationContext(), "4c251b8f40", false);
        LeakCanary.install(this);


        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
