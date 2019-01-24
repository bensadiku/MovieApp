package rx2retrofitmovieapp.com.ui.main;

import rx2retrofitmovieapp.com.models.Movies.MovieResponse;

public interface MainViewInterface {

    void showToast(String s);
    void showProgressBar();
    void hideProgressBar();
    void displayMovies(MovieResponse movieResponse);
    void displayError(String s);
}