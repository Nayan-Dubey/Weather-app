package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class weatherwindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherwindow);
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("humidity");
        String value2 = extras.getString("temperature");
        String value3 = extras.getString("speed");
        String value4 = extras.getString("city");
        String value5 = extras.getString("country");
        String value6= extras.getString("status");
        String value7= extras.getString("icon");
        TextView textView=findViewById(R.id.humi);
        TextView textView1=findViewById(R.id.tem);
        TextView textView5=findViewById(R.id.t);
        TextView textView2=findViewById(R.id.windspeed);
        TextView textView3=findViewById(R.id.city);
        TextView textView4=findViewById(R.id.country);
        TextView textView6=findViewById(R.id.status);
        textView.setText(value1);
        textView1.setText(value2);
        textView2.setText(value3+"Kmph");
        textView3.setText(value4);
        textView4.setText(value5);
        textView5.setText(value2);
        textView6.setText(value6);
        ImageView imageView=findViewById(R.id.imageView);
        switch (value7)
        {
            case "01d":
             imageView.setImageResource(R.drawable.sun);
             break;
            case "01n":
                imageView.setImageResource(R.drawable.a01n);
                break;
            case "02d":
                imageView.setImageResource(R.drawable.a02d);
                break;
            case "02n":
                imageView.setImageResource(R.drawable.a02n);
                break;
            case "03d":
                imageView.setImageResource(R.drawable.a03n);
                break;
            case "03n":
                imageView.setImageResource(R.drawable.a03n);
                break;
            case "09d":
                imageView.setImageResource(R.drawable.a09d);
                break;
            case "09n":
                imageView.setImageResource(R.drawable.a09d);
                break;
            case "10d":
                imageView.setImageResource(R.drawable.a10d);
                break;
            case "10n":
                imageView.setImageResource(R.drawable.a10d);
                break;
            case "11n":
                imageView.setImageResource(R.drawable.a11d);
                break;
            case "11d":
                imageView.setImageResource(R.drawable.a11d);
                break;
            case "13d":
                imageView.setImageResource(R.drawable.a13d);
                break;
            case "13n":
                imageView.setImageResource(R.drawable.a13d);
                break;
            default: imageView.setImageResource(R.drawable.sun);
        }
    }
}