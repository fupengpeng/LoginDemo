package com.demo.logindemo.crash;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import com.demo.logindemo.activity.personcenter.impl.LoginActivity;
import com.demo.logindemo.application.MyApplication;
import com.demo.logindemo.util.LogUtils;
import com.demo.logindemo.util.ToastUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 未知异常处理
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    /**
     * Application
     */
    private MyApplication application;

    public CrashHandler(MyApplication application) {
        this.application = application;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // 得到详细异常信息
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        String errorInfo = stringWriter.toString();
        LogUtils.i("errorInfo=" + errorInfo);

        // 上传

        // 提示用户重启
        // 主线程已经出异常了，快死了，提示显示不出来，创建工作线程
        new Thread() {
            public void run() {
                // 工作线程创建loop
                Looper.prepare();
                ToastUtils.showShort(application, "系统即将重启！");
                Looper.loop();
            }
        }.start();

        try {
            //不sleep,下面的代码立刻把程序结束了，提示看不到了
            Thread.currentThread().sleep(3000);
        } catch (Exception e) {
        }

        // 实现重启
        Intent intent = new Intent(application, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(application, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 定时器过1秒执行重启
        AlarmManager alarmManager = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
        //AlarmManager.RTC 程序锁屏，定时器不执行
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pendingIntent);

        // 结束当前程序的所有activity和进程
        application.finishActivity();
    }

}
