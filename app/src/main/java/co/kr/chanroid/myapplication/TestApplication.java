package co.kr.chanroid.myapplication;

import co.kr.chanroid.myapplication.dagger.components.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class TestApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
//        return null;
    }
}
