package com.free.mainctsk.l001activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnMain;
    private TextView maView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maView = (TextView)findViewById(R.id.maView);
        btnMain = (Button)findViewById(R.id.main_button);
        btnMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SlaveActivity.class);
                Bundle data = new Bundle();
                data.putString("message", "Hello Slave Activity!");
                i.putExtras(data);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        String string =  data.getStringExtra("message");
        maView.setText(string);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
