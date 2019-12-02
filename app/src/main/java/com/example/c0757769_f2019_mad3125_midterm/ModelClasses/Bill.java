package com.example.c0757769_f2019_mad3125_midterm.ModelClasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bill implements Parcelable
{

    @SerializedName("billId")
    @Expose
    @PrimaryKey(autoGenerate = true)

    private Integer billId;
    @SerializedName("billDate")
    @Expose
    private String billDate;
    @SerializedName("billType")
    @Expose
    private String billType;
    @SerializedName("billAmount")
    @Expose
    private Double billAmount;
    public final static Creator<Bill> CREATOR = new Creator<Bill>() {


        @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)


        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        public Bill[] newArray(int size) {
            return (new Bill[size]);
        }

    }
            ;

    protected Bill(Parcel in) {
        this.billId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.billDate = ((String) in.readValue((String.class.getClassLoader())));
        this.billType = ((String) in.readValue((String.class.getClassLoader())));
        this.billAmount = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */


    /**
     *
     * @param billAmount
     * @param billId
     * @param billType
     * @param billDate
     */
    public Bill(Integer billId, String billDate, String billType, Double billAmount) {
        super();
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.billAmount = billAmount;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(billId);
        dest.writeValue(billDate);
        dest.writeValue(billType);
        dest.writeValue(billAmount);
    }

    public int describeContents() {
        return 0;
    }

}
