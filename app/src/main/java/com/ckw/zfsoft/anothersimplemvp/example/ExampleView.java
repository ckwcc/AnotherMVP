package com.ckw.zfsoft.anothersimplemvp.example;

import com.ckw.zfsoft.anothersimplemvp.base.BaseView;
import com.ckw.zfsoft.anothersimplemvp.repository.NearbyPerson;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public interface ExampleView extends BaseView{

    void showExampleData(List<NearbyPerson> data);

}
