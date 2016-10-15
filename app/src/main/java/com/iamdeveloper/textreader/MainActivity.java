package com.iamdeveloper.textreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    InputStream stream;
    String music;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.text);

        stream = this.getResources().openRawResource(R.raw.music);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder str = new StringBuilder();
        String read;
        try {
            while((read = reader.readLine()) != null){
                str.append(read).append("\n");
            }

            Log.i("Reader",str.toString());
            music = str.toString();
            if (!music.isEmpty()){
                textview.setText(music);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
