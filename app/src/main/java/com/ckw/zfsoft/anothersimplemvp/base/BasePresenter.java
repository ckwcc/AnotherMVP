package com.ckw.zfsoft.anothersimplemvp.base;

import android.content.Context;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public interface BasePresenter  {
    Context getContext();

    void provideErrorMessage(String msg);
}
