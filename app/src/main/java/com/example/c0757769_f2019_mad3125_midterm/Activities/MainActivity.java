package com.example.c0757769_f2019_mad3125_midterm.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0757769_f2019_mad3125_midterm.Adapters.CustomerDataAdapter;
import com.example.c0757769_f2019_mad3125_midterm.DatabaseFiles.UserDatabase;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Customer;
import com.example.c0757769_f2019_mad3125_midterm.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity
{
    TextView mytext;
    List<Customer> myarraylist = new ArrayList<>();
    String temps;
    RecyclerView myrecycler;
    CardView mycardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myrecycler = (RecyclerView) findViewById(R.id.recycler_main);



        final UserDatabase uData = UserDatabase.getInstance(this);
        final Integer count = uData.daoObjct().count();
        if(count == 0)
        {
            //uData.clearAllTables();

            String temp1 = loadJSONFromAsset();
            Gson gson = new Gson();

            try {
                JSONArray jsonarray = new JSONArray(temp1);

                for(int i =0 ; i<=jsonarray.length();i++)
                {

                    temps = jsonarray.get(i).toString();
                    Customer cst = gson.fromJson(temps,Customer.class);
                    uData.daoObjct().insert(cst);

                }
            }catch (JSONException e)
            {
                e.printStackTrace();
            }
            //end of data from json

        }

        myarraylist = uData.daoObjct().getdefaultUserDetails();




        final CustomerDataAdapter myadapter = new CustomerDataAdapter(this);
        myadapter.setMyaaraylist(myarraylist);

        LinearLayoutManager mylinearlayout = new LinearLayoutManager(this);
        myrecycler.setLayoutManager(mylinearlayout);
        myrecycler.setAdapter(myadapter);

        uData.daoObjct().getUserDetails().observe(this, new Observer<List<Customer>>() {
            @Override
            public void onChanged(@Nullable List<Customer> customers) {
                myadapter.setMyaaraylist(customers);
                myadapter.notifyDataSetChanged();
            }
        });










    }






    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = MainActivity.this.getAssets().open("sample.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
