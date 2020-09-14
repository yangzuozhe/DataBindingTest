package com.example.databindingtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingtest.databinding.MyFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {
    MyFragmentBinding binding;
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //通过这种方式可以获得view
        binding =DataBindingUtil.inflate(inflater,R.layout.my_fragment,container,false);
            view=binding.getRoot();
        //不可以这么获得dataBinging，这是错误示范
//        View view=inflater.inflate(R.layout.my_fragment,container,false);
//        binding=DataBindingUtil.findBinding(view);
        initRecyclerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setMyFragment(this);
        binding.setLifecycleOwner(this);
        binding.setUser(new User("你好",false));
    }


    public void onClick(View view){
//        binding.setUser(new User("hahah"));
        Toast.makeText(view.getContext(),"sadsad",Toast.LENGTH_SHORT).show();

    }

    public void initRecyclerView(View view){
        List<User> userList=new ArrayList<>();
        userList.add(new User("yang",false));
        userList.add(new User("adsad",false));
        userList.add(new User("1111",false));
        userList.add(new User("2222",false));
        userList.add(new User("3333",false));
        userList.add(new User("4444",false));
        userList.add(new User("yang",false));
        userList.add(new User("5555",false));
        //无需findBy了,直接调用DataBinding,这里由于我在碎片布局中使用了Databinding才可以使用DataBinding
         recyclerView=binding.myRecyclerView;
        YnagRecyclerViewAdapter adapter=new YnagRecyclerViewAdapter(userList);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


}
