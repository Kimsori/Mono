package com.example.user.fuck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    TextView text;
    MapView map;
    int mMainValue = 0;
    TextView mMainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec Thread = tabHost.newTabSpec("Thread").setContent(R.id.Thread).setIndicator("스레드");
        TabHost.TabSpec DataBase = tabHost.newTabSpec("DataBase").setContent(R.id.DataBase).setIndicator("뮤지컬 목록");
        TabHost.TabSpec Ta_Map = tabHost.newTabSpec("Ta_Map").setContent(R.id.Ta_Map).setIndicator("구글 맵");

        tabHost.addTab(Thread);
        tabHost.addTab(DataBase);
        tabHost.addTab(Ta_Map);

        text = (TextView) findViewById(R.id.textView);

        map = (MapView) findViewById(R.id.map);

        mMainText = (TextView) findViewById(R.id.mainValue);




    }

    public void nextScene1( View view ){
        Intent i = new Intent(this, Main2Activity.class);
        this.startActivity( i );
    }
    public void nextScene2( View view ){
        Intent i = new Intent(this, Main3Activity.class);
        this.startActivity( i );
    }
    public void nextScene3( View view ){
        Intent i = new Intent(this, Main4Activity.class);
        this.startActivity( i );
    }

    public void nextScene4( View view ){
        Intent i = new Intent(this, Main5Activity.class);
        this.startActivity( i );
    }
    public void nextScene5( View view ){
        Intent i = new Intent(this, Main6Activity.class);
        this.startActivity( i );
    }
    public void nextScene6( View view ){
        Intent i = new Intent(this, Main7Activity.class);
        this.startActivity( i );
    }





    public void mOnClick(View v) {
        NumThread1 t1 = new NumThread1();

        t1.start();
    }

    Handler handler = new Handler() {
        int a = 0;
        int b = 0;
        int c = 0;

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mMainText.setText(String.valueOf(mMainValue++));
                    a = (int) (Math.random() * 256);
                    b = (int) (Math.random() * 256);
                    c = (int) (Math.random() * 256);
                    mMainText.setTextColor(Color.rgb(a, b, c));
                    break;


            }
        }
    };

    class NumThread1 extends Thread {
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(1000);
                    handler.sendMessage(handler.obtainMessage(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


