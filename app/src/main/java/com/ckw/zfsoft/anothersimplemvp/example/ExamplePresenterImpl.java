package com.ckw.zfsoft.anothersimplemvp.example;

import android.content.Context;

import com.ckw.zfsoft.anothersimplemvp.repository.NearbyPerson;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public class ExamplePresenterImpl implements ExamplePresenter {

    private ExampleModel mExampleModel;
    private ExampleView mExampleView;

    public ExamplePresenterImpl(ExampleView mExampleView) {
        this.mExampleView = mExampleView;
        mExampleModel = new ExampleModel(this);
    }

    @Override
    public Context getContext() {
        return mExampleView.getCurrentActivity();
    }

    @Override
    public void provideErrorMessage(String msg) {
        mExampleView.onError(msg);
    }

    @Override
    public void getExampleData(String name,String longitude,String latitude,String sex) {
        mExampleModel.getExampleDataFromServer(name,longitude,latitude,sex);
    }

    @Override
    public void provideExampleData(List<NearbyPerson> list) {
        mExampleView.showExampleData(list);
    }
}
