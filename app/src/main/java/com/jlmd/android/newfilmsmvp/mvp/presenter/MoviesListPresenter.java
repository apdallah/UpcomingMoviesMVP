package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;

/**
 * @author jlmd
 */
public abstract class MoviesListPresenter extends Presenter<MoviesListView> {

    public abstract void onSortButtonClick();

    public abstract void onMovieSelected(Movie movie);
}
