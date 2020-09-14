package com.example.databindingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingtest.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Databinding和活动绑定
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initData();
        initList();
    }

    public void initData(){
        viewModel=new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        //绑定viewModel
        binding.setViewModel(viewModel);
        binding.setUser(new User("aaaa",false));

        binding.setPhoto(new Photo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600023685748&di=ef10dec8a09d1c876f545b8560f59cab&imgtype=0&src=http%3A%2F%2Fa2.att.hudong.com%2F11%2F23%2F01300000251498122390237214116.jpg"));
        //绑定生命周期
        binding.setLifecycleOwner(this);
        //dataBinding和活动绑定，才可以再xml文件中使用android:onClick
        binding.setMainActivity(MainActivity.this);
        viewModel.getName().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                //这里就将DataBinding的和viewModel对User的值进行绑定，如果没有这句话，点击viewModel中的方法UI是不会变的，这里要注意 binding.setUser(new User())是DataBinding的方法，user.getFirstName()是viewModel的方法；
                binding.setUser(new User(user.getFirstName(),user.getIsAdult()));
            }
        });
    }


    public void initList(){
        //这里定义的集合必须和xml文件中的一样，集合是List类型，泛型是String类型
        List<String> list= new ArrayList<>();
        //这里我们添加两个值
        list.add("这是lsit的一个测试");
        list.add("不知道能不能成功");
        //然后通过DataBinding先将DataBinding和List进行绑定
        binding.setList(list);
        //然后设置我们自定义的setIndex将索引值和DataBinding进行绑定
        binding.setIndex(0);
    }

    /**
     * 可观察字段的用法
     * @param view
     */
    public void changDateUser2(View view){
        User2 user2=new User2();
        binding.setUser2(user2);
        user2.firstName.set("小明");
        user2.lastName.set("小红");
        user2.age.set(23);
    }

    /**
     * 可观察集合的用法
     * @param view
     */
    public void changDataUser2List(View view){
        ObservableArrayList<String> user=new ObservableArrayList<>();
        user.add("小明");
        user.add("小红");
        binding.setUser2list(user);

    }



}