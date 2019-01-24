package rx2retrofitmovieapp.com.ui.shows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx2retrofitmovieapp.com.R;
import rx2retrofitmovieapp.com.adapters.TvShowsAdapter;
import rx2retrofitmovieapp.com.models.TV.TvResponse;

public class ShowsActivity extends AppCompatActivity implements ShowsViewInterface {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.showsProgressBar)
    ProgressBar progressBar;

    @BindView(R.id.showsRecyclerView)
    RecyclerView rvShows;

    String TAG ="ShowsActivity";
    RecyclerView.Adapter adapter;
    ShowsPresenter showsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getShowsList();
    }
    private void setupMVP() {
        showsPresenter = new ShowsPresenter(this);
    }

    private void setupViews() {
        setSupportActionBar(toolbar);
        rvShows.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getShowsList() {
        showsPresenter.getShows();
    }



    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayResult(TvResponse tvResponse) {
        if(tvResponse!=null){
            Log.d(TAG, tvResponse.getResults().get(1).getName());
            adapter= new TvShowsAdapter(tvResponse.getResults(),ShowsActivity.this);
            rvShows.setAdapter(adapter);
        }
    }
}
