package com.example.user.fuck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView text;
    TextView mMainText;
    TextView idView;
    EditText musicalBox;
    EditText summaryBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        text = (TextView) findViewById(R.id.textView);


        mMainText = (TextView) findViewById(R.id.mainValue);


        idView = (TextView) findViewById(R.id.musicalID);
        musicalBox = (EditText) findViewById(R.id.musical);
        summaryBox = (EditText) findViewById(R.id.summary);

    }


    public void clearButtonClick(View view) {
        musicalBox.setText("");
        summaryBox.setText("");
    }

    public void newMusical(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Musical musical =
                new Musical(musicalBox.getText().toString(), summaryBox.getText().toString());
        dbHandler.addMusical(musical);
        musicalBox.setText("");
        summaryBox.setText("");
    }

    public void lookupMusical(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Musical musical =
                dbHandler.findMusical(musicalBox.getText().toString());
        if (musical != null) {
            idView.setText(String.valueOf(musical.getID()));
            summaryBox.setText(String.valueOf(musical.getSummary()));
        } else {
            idView.setText("일치하는 것이 없습니다");
        }
    }

    public void removeMusical(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteMusical(
                musicalBox.getText().toString());
        if (result) {
            idView.setText("레코드 삭제");
            musicalBox.setText("");
            summaryBox.setText("");
        } else
            idView.setText("일치하는 것이 없습니다");
    }
}