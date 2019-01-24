package rx2retrofitmovieapp.com.ui.shows;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import rx2retrofitmovieapp.com.models.TV.TvResponse;
import rx2retrofitmovieapp.com.network.NetworkClient;
import rx2retrofitmovieapp.com.network.NetworkInterface;

public class ShowsPresenter implements  ShowsPresenterInterface{

    ShowsViewInterface svi;

    private String TAG = "ShowsPresenter";

    public ShowsPresenter(ShowsViewInterface svi){
        this.svi = svi;
    }

    @Override
    public void getShows() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<TvResponse> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getShows("004cbaf19212094e32aa9ef6f6577f22")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<TvResponse> getObserver(){
        return new DisposableObserver<TvResponse>() {
            @Override
            public void onNext(TvResponse tvResponse) {
                Log.d(TAG, "onNext: "+tvResponse.getTotalResults());
                svi.displayResult(tvResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e);
                e.printStackTrace();
                svi.displayError("Error fetching movie data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                svi.hideProgressBar();
            }
        };
    }
}
