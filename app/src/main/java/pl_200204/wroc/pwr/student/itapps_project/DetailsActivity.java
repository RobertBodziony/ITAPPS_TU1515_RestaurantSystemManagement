package pl_200204.wroc.pwr.student.itapps_project;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Keczaps on 2016-04-06.
 */
public class DetailsActivity extends AppCompatActivity {

    int fromWhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);

        Intent intent = getIntent();
        fromWhere = intent.getIntExtra("fromWhere", 0);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE && fromWhere == 1) {
            finish();
            return;
        }


        if (savedInstanceState == null) {

            DetailsFragment detailsFragment = new DetailsFragment();

            detailsFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(android.R.id.content, detailsFragment).commit();

        }
    }
}