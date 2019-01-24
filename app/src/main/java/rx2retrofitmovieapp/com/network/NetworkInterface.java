package rx2retrofitmovieapp.com.network;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx2retrofitmovieapp.com.models.Movies.MovieResponse;
import rx2retrofitmovieapp.com.models.TV.TvResponse;


public interface NetworkInterface {

    @GET("discover/movie")
    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);

    @GET("search/movie")
    Observable<MovieResponse> getMoviesBasedOnQuery(@Query("api_key") String api_key, @Query("query") String q);

    @GET("discover/tv")
    Observable<TvResponse> getShows(@Query("api_key") String api_key);
}