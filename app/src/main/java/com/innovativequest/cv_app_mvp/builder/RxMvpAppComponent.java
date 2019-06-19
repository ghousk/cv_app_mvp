package com.innovativequest.cv_app_mvp.builder;

import android.content.Context;
import com.innovativequest.cv_app_mvp.networkservices.DataService;
import com.innovativequest.cv_app_mvp.utils.EnvironmentParameters;
import com.innovativequest.cv_app_mvp.utils.PreferencesManager;
import com.squareup.picasso.Picasso;
import com.twistedequations.rx2.AndroidRxSchedulers;
import dagger.Component;

@AppScope
@Component(modules = {RxMvpAppModule.class, NetworkModule.class, RestServiceModule.class, GsonModule.class, RxModule.class})
public interface RxMvpAppComponent {

    Context context();

    Picasso picasso();

    EnvironmentParameters environmentparameters();

    PreferencesManager preferencesmanager();

    AndroidRxSchedulers rxSchedulers();

    DataService lastFmService();

}
