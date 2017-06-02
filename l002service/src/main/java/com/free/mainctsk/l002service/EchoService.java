package com.free.mainctsk.l002service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by main.c.tsk on 2017/6/2.
 */

public class EchoService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        System.out.println("onBind");
        return echoServiceBinder;
    }

    private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
    public class EchoServiceBinder extends Binder {
        public EchoService getService(){
            return EchoService.this;
        }
    }

    public int getCurrentNum() {
        return i;
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        startTimer();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        stopTimer();
        super.onDestroy();
    }

    private int i = 0;
    private Timer timer = null;
    private TimerTask timerTask = null;

    public void startTimer() {
        if(null==timer) {
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    i++;
                    System.out.println(i);
                }
            };
        }
        timer.schedule(timerTask, 1000, 1000);
    }

    public void stopTimer() {
        if(timer!=null) {
            timerTask.cancel();
            timer.cancel();
            timer = null;
            timerTask = null;
        }
    }
}
