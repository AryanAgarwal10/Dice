package com.example.dice;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView i1=findViewById(R.id.imageView1);
        ImageView i2=findViewById(R.id.imageView2);
        int [] arr={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        Button btnTag = findViewById(R.id.roll);
        MediaPlayer mp= MediaPlayer.create(this,R.raw.dice_sound);

        Random rand= new Random();


        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

                i1.setImageResource(arr[rand.nextInt(6)]);
                i2.setImageResource(arr[rand.nextInt(6)]);
                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(i1);
                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(i2);
            }
        });

    }
}