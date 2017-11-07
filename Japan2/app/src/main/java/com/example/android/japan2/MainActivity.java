package com.example.android.japan2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout rl = (LinearLayout) findViewById(R.id.enter);


        new Thread() {
            int hue = 0;
            int saturation = 140; //adjust as per your need
            int value = 120; //adjust as per your need
            int flag = 0;


            public void run() {
                // Code to change background Continuously
                while (true) {


                    try {
                        sleep(60);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Now form a hsv float array from the 3 variables
                                if (hue == 255) {
                                    flag = 1;
                                }
                                if (hue == 0) {
                                    flag = 0;
                                }

                                if (flag == 0) {
                                    hue = hue + 1;
                                } else {
                                    hue = hue - 1;
                                }


                                float[] hsv = {hue, saturation, value};

                                //make color from that float array
                                int cl = Color.HSVToColor(hsv);

                                rl.setBackgroundColor(cl);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();//Code to change background continuously ends


    }
    //Function executed when button is clicked

    private String text() {
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        Log.d("dfsd", "efr");

        return (name);


    }

    public void Enter(View view) {


        if (Objects.equals(text(), "1")) {
            Log.d("dfsd", "efr111" + text());
            Button family = (Button) findViewById(R.id.enterPIN);

// Set a click listener on that View
            family.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent numbersIntent = new Intent(MainActivity.this, first.class);

                    startActivity(numbersIntent);

                }


            });
        }


    }
}
