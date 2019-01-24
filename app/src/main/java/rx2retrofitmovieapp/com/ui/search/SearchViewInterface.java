package rx2retrofitmovieapp.com.ui.search;

import rx2retrofitmovieapp.com.models.Movies.MovieResponse;

public interface SearchViewInterface {

    void showToast(String str);
    void displayResult(MovieResponse movieResponse);
    void displayError(String s);
    void showProgressBar();
    void hideProgressBar();
}