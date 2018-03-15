package com.example.saurav.dublinride;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurav Sharma (16573) on 10/03/2018.
 */

public class AttachAdapter extends ArrayAdapter {

    //creating array
    List list = new ArrayList();

    public AttachAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //add objects to the list
    public void add(Attachs object) {
        super.add(object);
        list.add(object);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View line;
        line = convertView;
        AttachHolder attachHolder;

        //condition if-else
        if(line==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            line = layoutInflater.inflate(R.layout.line_layout,parent,false);

            attachHolder = new AttachHolder();
            attachHolder.number_tx = (TextView) line.findViewById(R.id.number_tx);
            attachHolder.name_tx = (TextView) line.findViewById(R.id.name_tx);
            attachHolder.address_tx = (TextView) line.findViewById(R.id.address_tx);
            attachHolder.position_tx = (TextView) line.findViewById(R.id.position_tx);
            attachHolder.position1_tx = (TextView) line.findViewById(R.id.position1_tx);

            attachHolder.banking_tx = (TextView) line.findViewById(R.id.banking_tx);
            attachHolder.bonus_tx = (TextView) line.findViewById(R.id.bonus_tx);
            attachHolder.status_tx = (TextView) line.findViewById(R.id.status_tx);
            attachHolder.contract_name_tx = (TextView) line.findViewById(R.id.contract_name_tx);
            attachHolder.bike_stands_tx = (TextView) line.findViewById(R.id.bike_stands_tx);
            attachHolder.available_bike_stands_tx = (TextView) line.findViewById(R.id.available_bike_stands_tx);
            attachHolder.available_bikes_tx = (TextView) line.findViewById(R.id.available_bikes_tx);
            attachHolder.last_update_tx = (TextView) line.findViewById(R.id.last_update_tx);


            line.setTag(attachHolder);

        }

        else{

            attachHolder = (AttachHolder) line.getTag();
        }

        Attachs attachs = (Attachs) this.getItem(position);

        attachHolder.number_tx.setText(attachs.getNumber());
        attachHolder.name_tx.setText(attachs.getName());
        attachHolder.address_tx.setText(attachs.getAddress());
        attachHolder.position_tx.setText(attachs.getPosition());
        attachHolder.position1_tx.setText(attachs.getPosition1());

        attachHolder.banking_tx.setText(attachs.getBanking());
        attachHolder.bonus_tx.setText(attachs.getBonus());
        attachHolder.status_tx.setText(attachs.getStatus());
        attachHolder.contract_name_tx.setText(attachs.getContract_name());
        attachHolder.bike_stands_tx.setText(attachs.getBike_stands());
        attachHolder.available_bike_stands_tx.setText(attachs.getAvailable_bike_stands());
        attachHolder.available_bikes_tx.setText(attachs.getAvailable_bikes());
        attachHolder.last_update_tx.setText(attachs.getLast_update());



        return line;
    }

    //constructor
    static class AttachHolder
    {
        TextView number_tx,name_tx,address_tx,position_tx,position1_tx,banking_tx,bonus_tx,
                status_tx,contract_name_tx,bike_stands_tx,available_bike_stands_tx,available_bikes_tx,last_update_tx;
    }
}
