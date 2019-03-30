package com.example.viewpager2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewpager2.R;

public class MainActivity extends Activity {

    private Button btVertialPic;
    private Button btHorizontalPic;
    private Button btVerticalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVertialPic = findViewById(R.id.bt_vertical_pic);
        btVertialPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VerticalSlidePicActivity.class);
                intent.putExtra(VerticalSlidePicActivity.TYPE,VerticalSlidePicActivity.VERTICAL);
                startActivity(intent);
            }
        });

        btHorizontalPic = findViewById(R.id.bt_horizontal_pic);
        btHorizontalPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VerticalSlidePicActivity.class);
                intent.putExtra(VerticalSlidePicActivity.TYPE,VerticalSlidePicActivity.HORIZONTAL);
                startActivity(intent);
            }
        });

        btVerticalFragment = findViewById(R.id.bt_vertical_fragment);
        btVerticalFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VerticalSlideFrgActivity.class));
            }
        });
    }
}
