package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public void search(View view) {
        Intent i=new Intent(this,weatherwindow.class);


        String content;
        Weather weather= new Weather();
        try {
            EditText editText=findViewById(R.id.cityname);
            String input=editText.getText().toString();

            content = weather.execute("http://api.openweathermap.org/data/2.5/weather?q="+input+"&units=metric&appid=9ca38a6c1baf8b0c84a960f1dcfd830f").get();
            JSONObject jsonObject=new JSONObject(content);
            JSONObject res=jsonObject.getJSONObject("main");
            JSONObject wind=jsonObject.getJSONObject("wind");
            JSONObject country=jsonObject.getJSONObject("sys");
            JSONArray weathers=jsonObject.getJSONArray("weather");

            JSONObject wearr=weathers.getJSONObject(0);
            String icons=wearr.getString("icon");

            i.putExtra("humidity",res.getString("humidity"));
            i.putExtra("temperature",res.getString("temp"));
            i.putExtra("speed",wind.getString("speed"));
            i.putExtra("city",jsonObject.getString("name"));
            i.putExtra("country",country.getString("country"));
            i.putExtra("status",wearr.getString("main"));
            i.putExtra("icon",icons);
            startActivity(i);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void cal(View view) {
        EditText editText=findViewById(R.id.cityname);
        editText.setText("");

    }

    class Weather extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... address) {
            try {


                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                int data=isr.read();
                String content="";
                char ch;
                while(data!=-1)
                {
           ch=(char) data;
           content=content+ch;
           data=isr.read();

                }
                return content;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}