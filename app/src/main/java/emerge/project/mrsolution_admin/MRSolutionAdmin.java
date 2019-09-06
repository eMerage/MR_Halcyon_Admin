package emerge.project.mrsolution_admin;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import emerge.project.mrsolution_admin.data.realm_migrations.RealmMigrations;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MRSolutionAdmin extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}

