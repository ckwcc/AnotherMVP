package com.ckw.zfsoft.anothersimplemvp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ckw.zfsoft.anothersimplemvp.example.ExamplePresenterImpl;
import com.ckw.zfsoft.anothersimplemvp.example.ExampleView;
import com.ckw.zfsoft.anothersimplemvp.repository.NearbyPerson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ExampleView, View.OnClickListener {

    private TextView mShow;
    private Button mButton;

    private ExamplePresenterImpl mExamplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter();
        initView();
    }

    private void initView() {
        mShow = findViewById(R.id.tv_show);
        mButton = findViewById(R.id.btn_click);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onError(String e) {
        mShow.setText(e);
    }

    @Override
    public void setPresenter() {
        mExamplePresenter = new ExamplePresenterImpl(this);
    }

    @Override
    public Activity getCurrentActivity() {
        return this;
    }

    @Override
    public void showExampleData(List<NearbyPerson> data) {
        mShow.setText(data.toString());
    }

    @Override
    public void onClick(View v) {
        mExamplePresenter.getExampleData("255",null,null,"男");
    }
}
