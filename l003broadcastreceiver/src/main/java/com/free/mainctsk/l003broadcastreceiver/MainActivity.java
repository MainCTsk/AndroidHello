package com.free.mainctsk.l003broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBc, btnRegBc, btnUnregBc;
    private BcReceiver myBc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBc = new BcReceiver();
        btnBc = (Button)findViewById(R.id.btnBC);
        btnRegBc = (Button)findViewById(R.id.btnRegBc);
        btnUnregBc = (Button)findViewById(R.id.btnUnregBc);

        btnBc.setOnClickListener(this);
        btnRegBc.setOnClickListener(this);
        btnUnregBc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBC:
//                Intent i = new Intent(MainActivity.this, BcActivity.class);
                Intent i = new Intent(BcReceiver.ACTION);
                i.putExtra("message", "broadcast receiver");
                sendBroadcast(i);
                break;
            case R.id.btnRegBc:
                registerReceiver(myBc, new IntentFilter(BcReceiver.ACTION));
                break;
            case R.id.btnUnregBc:
                unregisterReceiver(myBc);
                break;
            default:
                break;
        }
    }
}
