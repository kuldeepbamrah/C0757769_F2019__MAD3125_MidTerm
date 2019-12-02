package com.example.c0757769_f2019_mad3125_midterm.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0757769_f2019_mad3125_midterm.R;

public class CustomerDetailActivity extends AppCompatActivity
{
    TextView custid, custname, custemail, custage;
    RecyclerView myrecycler;
    TextView detailtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
    }
}
