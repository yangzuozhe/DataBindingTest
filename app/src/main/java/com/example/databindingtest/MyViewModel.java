package com.example.databindingtest;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends AndroidViewModel {
    MutableLiveData<User> mutableLiveData;
    MutableLiveData<User2> user2MutableLiveData;
    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> getName(){
        if (mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    public void setName(String name){
        mutableLiveData.setValue(new User(name,true));
    }


    public void changData(View view){
        setName("阳太");

    }




}
