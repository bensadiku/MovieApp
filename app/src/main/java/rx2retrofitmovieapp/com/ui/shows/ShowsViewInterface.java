package rx2retrofitmovieapp.com.ui.shows;

import rx2retrofitmovieapp.com.models.TV.TvResponse;

public interface ShowsViewInterface {

    void showToast(String str);
    void displayResult(TvResponse tvResponse);
    void displayError(String s);
    void showProgressBar();
    void hideProgressBar();
}
