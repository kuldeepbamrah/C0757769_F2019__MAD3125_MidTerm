package com.example.c0757769_f2019_mad3125_midterm.DatabaseFiles;

import androidx.room.TypeConverter;

import com.example.c0757769_f2019_mad3125_midterm.ModelClasses.Bill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converter
{
    @TypeConverter
    public static List<Bill> fromString(String value)
    {
        Type listType = new TypeToken<List<Bill>>() {}.getType();
        return new Gson().fromJson(value,listType);
    }

    @TypeConverter
    public static  String fromBill(List<Bill> bill)
    {
        Gson gson = new Gson();
        String json = gson.toJson(bill);
        return json;
    }

}