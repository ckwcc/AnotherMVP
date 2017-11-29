package com.ckw.zfsoft.anothersimplemvp.example;

import android.content.Context;

import com.ckw.zfsoft.anothersimplemvp.base.BaseModel;
import com.ckw.zfsoft.anothersimplemvp.netloader.AppNetLoader;
import com.ckw.zfsoft.anothersimplemvp.netloader.BaseObserver;
import com.ckw.zfsoft.anothersimplemvp.netloader.HttpResult;
import com.ckw.zfsoft.anothersimplemvp.repository.NearbyPerson;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public class ExampleModel extends BaseModel {

    private Context mContext;
    private ExamplePresenter mPresenter;

    public ExampleModel(ExamplePresenter mPresenter) {
        this.mPresenter = mPresenter;
        mContext = mPresenter.getContext();
    }

    public void getExampleDataFromServer(String name,String longitude,String latitude,String sex){
        AppNetLoader.getInstance().async(AppNetLoader.getInstance().getService().getNearbyPersonList(name, longitude, latitude, sex),
                new BaseObserver<List<NearbyPerson>>() {
                    @Override
                    protected void setNeedContext() {
                        setContext(mContext);
                    }

                    @Override
                    protected void _onNext(List<NearbyPerson> list) {
                        mPresenter.provideExampleData(list);
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        mPresenter.provideErrorMessage(e.toString());
                    }
                });
    }
}
