package com.example.saurav.dublinride;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Saurav Sharma (16573) on 10/03/2018.
 */

public class ListMainActivity extends Activity {

    //variable
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);
    }
    public void findJSON(View view){

        new BackgroundTask().execute();


    }


    class BackgroundTask extends AsyncTask<Void,Void,String> {

        //variable
        String json_url;
        String JSON_STRING;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            json_url="https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=ca858054d4cba4436171b315e97ffc10139ce155";
        }

        @Override
        protected String doInBackground(Void... voids) {

            //fetching data from api key
            try {

                URL url = new  URL(json_url);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) !=null)
                {

                    stringBuilder.append(JSON_STRING+ "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpsURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = findViewById(R.id.text_view);
            textView.setText(result);

            json_string = result;
        }
    }
    // new activity with the avaiable json data
    public void passJSON(View view)
    {

        if (json_string ==null){
            Toast.makeText(getApplicationContext(),"1st click Get JSON", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this,DisplayLV.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }

    }
}
