package co.kr.chanroid.myapplication.dagger.modules;

import co.kr.chanroid.myapplication.FirstFragment;
import co.kr.chanroid.myapplication.MainActivity;
import co.kr.chanroid.myapplication.dagger.scopes.ActivityScope;
import co.kr.chanroid.myapplication.dagger.scopes.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @FragmentScope
    @ContributesAndroidInjector
    abstract FirstFragment firstFragment();
}
