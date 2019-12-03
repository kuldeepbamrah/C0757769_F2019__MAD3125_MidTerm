package com.example.c0757769_f2019_mad3125_midterm.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.c0757769_f2019_mad3125_midterm.DatabaseFiles.UserDatabase;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Bill;
import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Customer;
import com.example.c0757769_f2019_mad3125_midterm.R;

import java.util.List;


public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {

    private Activity context;
    private Customer customer;
    private List<Bill> myaaraylist;


    public BillAdapter(Activity context) {
        this.context = context;

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public List<Bill> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Bill> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_cell, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Bill mydata = myaaraylist.get(position);

        final String billidtemp = String.valueOf(mydata.getBillId());

        holder.billid.setText("Bill ID: " + billidtemp);
        holder.billtype.setText("Bill Type: " + mydata.getBillType());
        holder.billdate.setText("Bill Date: " + mydata.getBillDate());
        holder.billamount.setText("Bill Amount: " + mydata.getBillAmount() + " $");


        holder.mycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String alldatavehicle = "Bill ID: " + billidtemp + "\n" + "Bill Type: " + mydata.getBillType() + "\n" + "Bill Date: " + mydata.getBillDate() + "\n" + "Bill Amount: " + mydata.getBillAmount() + " $";
                //  Toast.makeText(context,"position = "+position,Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return myaaraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView billid, billdate, billtype, billamount;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcard);
            billid = itemView.findViewById(R.id.textView1);
            billtype = (TextView) itemView.findViewById(R.id.textView2);
            billdate = (TextView) itemView.findViewById(R.id.textView3);
            billamount = (TextView) itemView.findViewById(R.id.textView4);


        }
    }

    public void deleteItem(int position)
    {
        Bill bill = myaaraylist.get(position);
        myaaraylist.remove(position);
        List<Bill> bills = customer.getBill();
        bills.remove(bill);
        UserDatabase userDatabase = UserDatabase.getInstance(getContext());
        userDatabase.daoObjct().update(customer);
        notifyDataSetChanged();

    }


}
