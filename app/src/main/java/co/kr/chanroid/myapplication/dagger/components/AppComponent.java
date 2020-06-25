package co.kr.chanroid.myapplication.dagger.components;

import android.app.Application;

import javax.inject.Singleton;

import co.kr.chanroid.myapplication.TestApplication;
import co.kr.chanroid.myapplication.dagger.modules.ActivityBindingModule;
import co.kr.chanroid.myapplication.dagger.modules.ApplicationModule;
import co.kr.chanroid.myapplication.dagger.modules.RetrofitModule;
import co.kr.chanroid.myapplication.dagger.modules.TestModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        TestModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        RetrofitModule.class
})
public interface AppComponent extends AndroidInjector<TestApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}
