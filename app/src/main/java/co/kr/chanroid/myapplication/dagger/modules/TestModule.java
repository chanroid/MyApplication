package co.kr.chanroid.myapplication.dagger.modules;

import android.content.Context;

import co.kr.chanroid.myapplication.dagger.TestBean;
import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    @Provides
    public TestBean provideTestBean(Context context) {
        return new TestBean(context);
    }
}
