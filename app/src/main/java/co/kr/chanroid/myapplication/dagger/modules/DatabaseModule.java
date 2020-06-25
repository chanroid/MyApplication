package co.kr.chanroid.myapplication.dagger.modules;

import android.content.Context;

import com.squareup.sqldelight.android.AndroidSqliteDriver;
import com.squareup.sqldelight.db.SqlDriver;

import javax.inject.Singleton;

import co.kr.chanroid.myapplication.Database;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    @Singleton
    public SqlDriver provideSqlDriver(Context context) {
        return new AndroidSqliteDriver(Database.Companion.getSchema(), context, "database.db");
    }

    @Provides
    @Singleton
    public Database provideDataBase(SqlDriver driver) {
        return Database.Companion.invoke(driver);
    }
}
