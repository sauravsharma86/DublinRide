package com.example.saurav.dublinride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Saurav Sharma (16573) on 10/03/2018.
 */

public class DisplayLV extends AppCompatActivity {

    //variables
    String json_string;
    AttachAdapter attachAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_lv);

        listView = (ListView) findViewById(R.id.list_View);


        //adding adapter to the list view
        attachAdapter = new AttachAdapter(this,R.layout.line_layout);
        listView.setAdapter(attachAdapter);

        //opening new intent
        json_string = getIntent().getExtras().getString("json_data");

        //try & catch to get item of the list
        try {


            JSONArray json = new JSONArray(json_string);


            int count = 0;

            String number,name,address,position,position1,banking,bonus,status,contract_name,bike_stands,available_bike_stands,available_bikes,last_update;

            while (count<json.length())
            {
                JSONObject JO = json.getJSONObject(count);

                JSONObject jb = JO.getJSONObject("position");

                jb.get("lat");
                jb.get("lng");

//                Log.i("latitude", jb.getString("lat"));

                // marker arrays connected to get data from list item to add marker
                Attachs.myList1.add((double)jb.get("lat")); // latitude
                Attachs.myList2.add((double)jb.get("lng")); //longitude
                Attachs.myStation.add((String)JO.get("name"));


                //getting string data
                number = JO.getString("number");
                name = JO.getString("name");
                address = JO.getString("address");

                //spliting position into lati and longi
                position= jb.getString("lat");
                position1 = jb.getString("lng");

                banking = JO.getString("banking");
                bonus = JO.getString("bonus");
                status = JO.getString("status");
                contract_name = JO.getString("contract_name");
                bike_stands = JO.getString("bike_stands");
                available_bike_stands = JO.getString("available_bike_stands");
                available_bikes = JO.getString("available_bikes");
                last_update = JO.getString("last_update");

                Attachs attachs = new Attachs ("Station Number: "+ number,"Name: "+name,
                        "Address: "+address,"Latitude: "+position,"Longitude: "+position1,
                        "Banking: "+banking,"Bonus: "+bonus,"status: "+status,
                        "contractName: "+contract_name, "bikeStands: "+bike_stands,
                        "availableStands: "+available_bike_stands,
                        "availableBikes: "+available_bikes, "lastUpdate: "+last_update);

                attachAdapter.add(attachs);


                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}

