package com.ckw.zfsoft.anothersimplemvp.example;

import com.ckw.zfsoft.anothersimplemvp.base.BasePresenter;
import com.ckw.zfsoft.anothersimplemvp.repository.NearbyPerson;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public interface ExamplePresenter extends BasePresenter{

    void getExampleData(String name,String longitude,String latitude,String sex);

    void provideExampleData(List<NearbyPerson> list);
}
