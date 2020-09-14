package com.example.databindingtest;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseObservable {
    private String firstName;
    private boolean isAdult;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public User(String firstName, boolean isAdult) {
        this.firstName = firstName;
        this.isAdult = isAdult;
    }

    @Bindable
    public boolean getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
        notifyPropertyChanged(BR.isAdult);
    }


}
