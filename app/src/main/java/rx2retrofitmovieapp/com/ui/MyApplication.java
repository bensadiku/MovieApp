package rx2retrofitmovieapp.com.ui;

import android.app.Application;

import rx2retrofitmovieapp.com.di.components.ApplicationComponent;
import rx2retrofitmovieapp.com.di.components.DaggerApplicationComponent;
import rx2retrofitmovieapp.com.di.modules.ApplicationModule;




public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public MyApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

}