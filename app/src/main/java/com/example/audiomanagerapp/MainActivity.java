package com.example.audiomanagerapp;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mode,ring,vibrate,silent;
    private AudioManager myAudioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        vibrate=(Button)findViewById(R.id.button3);
        ring=(Button)findViewById(R.id.button2);

        mode=(Button)findViewById(R.id.button);
        silent=(Button)findViewById(R.id.button4);
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                        Toast.LENGTH_LONG).show();
            }
        });
        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                        Toast.LENGTH_LONG).show();
            }
        });
        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this,"Now in silent Mode",
                        Toast.LENGTH_LONG).show();
            }
        });
        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod=myAudioManager.getRingerMode();
                if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                } else if(mod==AudioManager.RINGER_MODE_NORMAL){
                    Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}