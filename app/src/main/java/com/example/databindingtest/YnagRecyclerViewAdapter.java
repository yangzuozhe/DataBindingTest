package com.example.databindingtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.databindingtest.databinding.MyRecyclerviewBinding;

import java.util.List;

public class YnagRecyclerViewAdapter extends RecyclerView.Adapter<YnagRecyclerViewAdapter.MyViewHolder> {
    MyRecyclerviewBinding binding;
    List<User> mList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //由于我们在xml文件中使用了databinding所以,不要需要findBy了,直接让textView和binding中的TextView相等
            textView = binding.myRecyclerviewTextview;
        }

        public void bindTo(User user) {
            binding.setUser(user);
            //这是立即Binding的意思;
            //当一个变量或可观察对象发生更改时，绑定会安排在下一帧更改之前。然而，有时候，绑定必须立即执行，要想强制执行，请使用 executePendingBindings() 方法。
            binding.executePendingBindings();
        }
    }

    public YnagRecyclerViewAdapter(List<User> list) {
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //获得dataBinding
        binding = DataBindingUtil.inflate(inflater, R.layout.my_recyclerview, parent, false);
        //这里通过DataBinding获得View
        View view = binding.getRoot();
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final User user = mList.get(position);
        //这里用到了我们在viewHolder中自定义的bindTo方法,将数据通过DataBinding传进进User中
        holder.bindTo(user);
        //这是点击事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), user.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
