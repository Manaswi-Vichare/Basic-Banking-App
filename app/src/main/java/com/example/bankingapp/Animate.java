package com.example.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Animate extends AppCompatActivity {
    TextView by,name,basic,banking;
    ImageView coin;
    Button startButton;
    public void startAnimate(){
        coin.animate().translationYBy(-2000).setDuration(0).withEndAction(() -> coin.animate().translationYBy(2000).setDuration(1000));
        basic.animate().scaleX(0f).scaleY(0f).setDuration(0).withEndAction(() -> basic.animate().scaleX(1f).scaleY(1f).setDuration(1000));
        banking.animate().scaleX(0f).scaleY(0f).setDuration(0).withEndAction(() -> banking.animate().scaleX(1f).scaleY(1f).setDuration(1000));
        by.animate().translationYBy(2000).setDuration(0).withEndAction(() -> by.animate().translationYBy(-2000).setDuration(1000));
        name.animate().translationYBy(2000).setDuration(0).withEndAction(() -> name.animate().translationYBy(-2000).setDuration(1000));
        startButton.animate().translationXBy(800).setDuration(0).withEndAction(() -> startButton.animate().translationXBy(-800).setDuration(1000));
    }
    public void start(View view){
        Intent startAct= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(startAct);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_animate);
        by = findViewById(R.id.byText);
        name = findViewById(R.id.nameText);
        basic = findViewById(R.id.basic);
        banking = findViewById(R.id.bankingLabel);
        coin = findViewById(R.id.coinImg);
        startButton = findViewById(R.id.startButton);
        startAnimate();
    }
}
