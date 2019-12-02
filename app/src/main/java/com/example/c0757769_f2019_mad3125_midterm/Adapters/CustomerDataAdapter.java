package com.example.c0757769_f2019_mad3125_midterm.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Customer;
import com.example.c0757769_f2019_mad3125_midterm.R;


import java.util.List;


public class CustomerDataAdapter extends RecyclerView.Adapter<CustomerDataAdapter.ViewHolder> {

    private Context context;
    private List<Customer> myaaraylist;


    public CustomerDataAdapter(Context context) {
        this.context = context;

    }




    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Customer> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Customer> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_detail_cell,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

        final Customer mydata = myaaraylist.get(position);

        String fname = mydata.getFirstName() + " " + mydata.getLastName();

        holder.name.setText("Customer Name: "+ fname);
        holder.id.setText("Customer ID: "+mydata.getId().toString());
        holder.age.setText("CUstomer Age: "+mydata.getAge().toString()+" Years");


//        if(myvehicle == null)
//        {
//            holder.type.setText("No Vehicle");
//            holder.type.setTextColor(Color.RED);
//            holder.type.setTextSize(20);
//
//            holder.plate.setVisibility(View.GONE);
//            holder.make.setVisibility(View.GONE);
//            holder.model.setVisibility(View.GONE);
//
//
//        }
//        else {
//            holder.type.setText("Vehicle Type: "+myvehicle.getType());
//            holder.make.setText("Vehicle Make: "+myvehicle.getMake());
//            holder.model.setText("Vehicle Model: "+myvehicle.getModel());
//            holder.plate.setText("Vehicle Plate: "+myvehicle.getPlate());
//
//        }




//        holder.mycardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent myintent = new Intent(context, CustomerDetailsActivity.class);
//                myintent.putExtra("custobject",mydata);
//                context.startActivity(myintent);
//              //  Toast.makeText(context,"position = "+position,Toast.LENGTH_LONG).show();
//
//            }
//        });

    }





    @Override
    public int getItemCount() {
        return myaaraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, id;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcard);
            id = (TextView)itemView.findViewById(R.id.textView2);
            name = (TextView)itemView.findViewById(R.id.textView3);
            age = (TextView)itemView.findViewById(R.id.textView5);




        }
    }


}
