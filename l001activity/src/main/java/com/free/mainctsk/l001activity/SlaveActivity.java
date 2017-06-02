package com.free.mainctsk.l001activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by main.c.tsk on 2017/6/2.
 */

public class SlaveActivity extends Activity {

    private Button btnSlave;
    private TextView txView;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_slave);

        btnSlave = (Button)findViewById(R.id.slave_button);
        btnSlave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("message", "Hello Main Activity");
                setResult(0, i);
                finish();
            }
        });

        txView = (TextView)findViewById(R.id.slView);
        Bundle data = getIntent().getExtras();
        txView.setText(data.getString("message"));
    }

}
