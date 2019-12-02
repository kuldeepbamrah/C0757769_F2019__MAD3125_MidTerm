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
        holder.age.setText("Customer Age: "+mydata.getAge().toString()+" Years");


        

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
