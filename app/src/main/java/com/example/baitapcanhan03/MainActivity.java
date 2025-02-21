package com.example.baitapcanhan03;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        int[] images = {
                R.drawable.background_intro,
                R.drawable.pizza,
                R.drawable.cat_3,
        };


        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Random random = new Random();
                    int randomImage;

                    int lastImage=0;
                    do {
                        randomImage = images[random.nextInt(images.length)];
                    } while (randomImage == lastImage);
                    lastImage = randomImage;

                    Toast.makeText(MainActivity.this,"Change Background", Toast.LENGTH_SHORT).show();
                    ImageView img1 = findViewById(R.id.imageView1);
                    img1.setImageResource(randomImage);
                }else {
                    Random random = new Random();
                    int randomImage = images[random.nextInt(images.length)];

                    int lastImage=0;
                    do {
                        randomImage = images[random.nextInt(images.length)];
                    } while (randomImage == lastImage);
                    lastImage = randomImage;

                    Toast.makeText(MainActivity.this,"Change Background", Toast.LENGTH_SHORT).show();
                    ImageView img1 = findViewById(R.id.imageView1);
                    img1.setImageResource(randomImage);
                }
            }
        });
    }


}