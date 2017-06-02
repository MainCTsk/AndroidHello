package com.free.mainctsk.l002service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection{

    private Button btnStartService, btnStopService, btnBindService, btnUnbindService, btnGetNum;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent(MainActivity.this, EchoService.class);

        btnStartService = (Button)findViewById(R.id.btnStartService);
        btnStopService = (Button)findViewById(R.id.btnStopService);
        btnBindService = (Button)findViewById(R.id.btnBindService);
        btnUnbindService = (Button)findViewById(R.id.btnUnbindService);
        btnGetNum = (Button)findViewById(R.id.btnGetNum);

        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        btnGetNum.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnStartService:
                startService(serviceIntent);
                break;
            case R.id.btnStopService:
                stopService(serviceIntent);
                break;
            case R.id.btnBindService:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService:
                unbindService(this);
                break;
            case R.id.btnGetNum:
                if(echoService!=null)
                    System.out.println("Echo service num is " + echoService.getCurrentNum());
                break;
            default:
                break;
        }
    }

    private EchoService echoService = null;

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {

        System.out.println("onServiceConnected");
        echoService = ((EchoService.EchoServiceBinder)binder).getService();
        System.out.println(echoService.getCurrentNum());
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("onServiceDisconnected");
    }
}
