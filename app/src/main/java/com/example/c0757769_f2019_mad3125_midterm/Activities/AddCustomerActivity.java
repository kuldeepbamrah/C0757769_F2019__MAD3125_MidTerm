package com.example.c0757769_f2019_mad3125_midterm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c0757769_f2019_mad3125_midterm.DatabaseFiles.UserDatabase;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Customer;
import com.example.c0757769_f2019_mad3125_midterm.R;

public class AddCustomerActivity extends AppCompatActivity implements View.OnClickListener {

    EditText id,fname,lname,age,email;
    Button mybutton;
    String custid ;
    String custage ;
    String custfname ;
    String custlname ;
    String custemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        id = findViewById(R.id.editTextCustID);
        fname = findViewById(R.id.editTextCustfname);
        lname = findViewById(R.id.editTextCustlname);
        age = findViewById(R.id.editTextCustage);
        email = findViewById(R.id.editTextCustemail);

        mybutton = findViewById(R.id.buttoncustomer);
        mybutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        createCust();

        //Intent myintent = new Intent(this,MainActivity.class);
        //startActivity(myintent);






    }

    public void createCust()
    {
        custid = id.getText().toString();
        custage = age.getText().toString();
        custfname = fname.getText().toString();
        custlname = lname.getText().toString();
        custemail = email.getText().toString();

        if(custid.equals(null)||custage.equals(null)||custfname.equals(null)||custlname.equals(null)||custemail.equals(null))
        {
            Toast.makeText(AddCustomerActivity.this,"Please fill all the Field",Toast.LENGTH_SHORT).show();
        }else {
            Customer tempobject = new Customer(Integer.parseInt(custid), custfname, custlname, Integer.parseInt(custage), custemail);
            final UserDatabase uData = UserDatabase.getInstance(AddCustomerActivity.this);
            uData.daoObjct().insert(tempobject);
            finish();
        }


    }



}

