package com.android.dhara.muviapp.home.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.model.HomeDataModel;

import javax.inject.Inject;

public class HomeViewImpl implements HomeView, NavigationView.OnNavigationItemSelectedListener {
    private AppCompatActivity activity;
    private DrawerLayout drawer;
    private TextView txtName;
    private TextView txtEmail;
    private TextView txtPhoneNumber;
    private TextView txtLocation;
    private ActionBarDrawerToggle toggle;
    private ViewInteractionListener listener;
    private Toolbar toolbar;

    @Inject
    public HomeViewImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initViews(final ViewInteractionListener listener) {
        this.listener = listener;
        setUpToolbar();

        final NavigationView navigationView = activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final View headerView = navigationView.getHeaderView(0);
        txtName = headerView.findViewById(R.id.txt_name);
        txtEmail = headerView.findViewById(R.id.txt_email);
        txtPhoneNumber = headerView.findViewById(R.id.txt_phone_number);
        txtLocation = headerView.findViewById(R.id.txt_location);
    }

    @Override
    public void updateData(@NonNull final HomeDataModel dataModel) {
        txtName.setText(dataModel.getUser().getUserResponse().getName());
        txtEmail.setText(dataModel.getUser().getUserResponse().getUserName());
        txtPhoneNumber.setText(dataModel.getUser().getUserResponse().getPhoneNumber());
        txtLocation.setText(dataModel.getUser().getLocation().getLocationName());
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(drawer, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean closeDrawerLayout() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            activity.getSupportFragmentManager().popBackStack();
            return true;
        }
        return false;
    }

    @Override
    public void handleOnNavigationClicked() {
        if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            activity.getSupportFragmentManager().popBackStack();
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    private void setUpToolbar() {
        toolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);

        drawer = activity.findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(activity, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setToolbarNavigationClickListener(view -> listener.onNavigationClicked());
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // open profile screen
        } else if (id == R.id.nav_categories) {
            listener.onCategoriesClicked();
        } else if (id == R.id.nav_signout) {
            listener.onSignedOut();
        } else if (id == R.id.nav_share) {
            // perform share
        }

        drawer = activity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void handleOnDrawerToggleUpdate(final boolean isDrawerToggleIndicatorEnabled) {
        if (isDrawerToggleIndicatorEnabled) {
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            toggle.setHomeAsUpIndicator(R.mipmap.baseline_arrow_back_white_24);
        }
        toggle.setDrawerIndicatorEnabled(isDrawerToggleIndicatorEnabled);
        drawer.addDrawerListener(toggle);
    }
}
