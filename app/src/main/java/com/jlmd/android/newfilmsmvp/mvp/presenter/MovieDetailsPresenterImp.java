package com.jlmd.android.newfilmsmvp.mvp.presenter;

import android.util.Log;

import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;
import com.jlmd.android.newfilmsmvp.mvp.view.MovieDetailsView;

/**
 * @author jlmd
 */
public class MovieDetailsPresenterImp extends MovieDetailsPresenter {

    private MovieDetailsApi movieDetailsApi;
    private final static String TAG = MovieDetailsPresenterImp.class.getSimpleName();

    public MovieDetailsPresenterImp(MovieDetailsApi movieDetailsApi) {
        this.movieDetailsApi = movieDetailsApi;
    }

    @Override
    public void onMovieReceive(Movie movie) {
        loadMovieDetails(movie);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private void loadMovieDetails(final Movie movie) {
        movieDetailsApi.getMovieDetails(movie.getId(), new MovieDetailsApi.Callback() {
            @Override
            public void onFinish(MovieDetails movieDetails) {
                movie.setMovieDetails(movieDetails);
                view.renderMovie(movie);
                view.hideLoading();
            }

            @Override
            public void onError(String errorMessage) {
                // TODO Show error message in view
                Log.i(TAG, "Error: " + errorMessage);
                view.hideLoading();
            }
        });
    }

}
