package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private TextView textToDisplay1;
    private TextView textToDisplay2;
    private TextView textToDisplay3;
    private Button button1;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView5);

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Adding animation here:
                final Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                final Animation anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int value = randomDiceValue();
                        int res = getResources().getIdentifier("dice_" + value, "drawable", "com.example.dice");
                        TextView textToDisplay1 = findViewById(R.id.textView);
                        textToDisplay1.setText(String.valueOf(value));
                        imageView1.setImageResource(res);
                        int value2 = randomDiceValue();
                        int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.dice");
                        TextView textToDisplay2 = findViewById(R.id.textView3);
                        textToDisplay2.setText(String.valueOf(value2));
                        imageView2.setImageResource(res2);
                        int sum = value + value2;
                        TextView textToDisplay3 = findViewById(R.id.textView4);
                        textToDisplay3.setText(String.valueOf(sum));

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };
                anim1.setAnimationListener(animationListener);
                anim2.setAnimationListener(animationListener);

                imageView1.startAnimation(anim1);
                imageView2.startAnimation(anim2);

            }
        });

    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }
}
