package com.innovativequest.cv_app_mvp.builder;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ghous on 17/06/2019.
 */
@Module
public class RxMvpAppModule {

    private final Context context;

    public RxMvpAppModule(Context context) {
        this.context = context;
    }

    @Provides
    @AppScope
    public Context context() {
        return context;
    }

}
