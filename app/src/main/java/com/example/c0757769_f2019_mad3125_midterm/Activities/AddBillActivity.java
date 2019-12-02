package com.example.c0757769_f2019_mad3125_midterm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.c0757769_f2019_mad3125_midterm.DatabaseFiles.UserDatabase;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Bill;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Customer;
import com.example.c0757769_f2019_mad3125_midterm.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddBillActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText id,date,amount,type;
    final Calendar myCalendar = Calendar.getInstance();

    Button mybutton;
    String bid ;
    String bdate ;
    String bamount ;
    String btype ;

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        id = findViewById(R.id.editTextbillID);
        date = findViewById(R.id.editTextbilldate);
        amount = findViewById(R.id.editTextbillamount);
        type = findViewById(R.id.editTextBillType);



        mybutton = findViewById(R.id.buttonbill);
        mybutton.setOnClickListener(this);

        date.setOnClickListener(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.billtype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        type.setOnClickListener(this);






    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textposition = parent.getSelectedItem().toString();
        type.setText(textposition);
        Toast.makeText(view.getContext(),textposition,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        type.setText("");

    }

    DatePickerDialog.OnDateSetListener mydate = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };



    private void updateLabel() {
        String myFormat = "MMM-dd-yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        date.setText(sdf.format(myCalendar.getTime()));
    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case  R.id.buttonbill:
                createBill();
                break;
            case  R.id.editTextbilldate:
                new DatePickerDialog(v.getContext(), mydate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.editTextBillType:
                spinner.performClick();

        }


        //Intent myintent = new Intent(this,MainActivity.class);
        //startActivity(myintent);






    }

    public void createBill()
    {
        bid = id.getText().toString();
        btype = type.getText().toString();
        bdate = date.getText().toString();
        bamount = amount.getText().toString();



        Customer custtemp =getIntent().getParcelableExtra("custobjectvehicle");
        Bill tempobject = new Bill(Integer.parseInt(bid),bdate,btype,Double.parseDouble(bamount));
        final UserDatabase uData = UserDatabase.getInstance(AddBillActivity.this);
        custtemp.setmyBill(tempobject);
        uData.daoObjct().update(custtemp);

        finish();







    }





}

