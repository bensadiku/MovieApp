package rx2retrofitmovieapp.com.di.modules;
import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private Application app;

    public ApplicationModule(Application app){
        this.app = app;
    }


    @Provides
    @Singleton
    Context provideContext(){
        return app;
    }

}