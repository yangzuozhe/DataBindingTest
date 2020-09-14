package com.example.databindingtest;

import android.database.Observable;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;

public class User2 {
    public final ObservableField<String> firstName=new ObservableField<>();
    public final ObservableField<String> lastName=new ObservableField<>();
    public final ObservableInt age=new ObservableInt();

    ObservableList<String> user=new ObservableArrayList<>();




}
