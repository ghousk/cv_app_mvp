package com.innovativequest.cv_app_mvp.builder;

import com.twistedequations.rx2.AndroidRxSchedulers;
import com.twistedequations.rx2.DefaultAndroidRxSchedulers;
import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @AppScope
    @Provides
    public AndroidRxSchedulers rxSchedulers() {
        return new DefaultAndroidRxSchedulers();
    }
}
