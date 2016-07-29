package com.gmail.dafelcardozo.recrutamentoandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class EpisodeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final List<String> values = Arrays.asList(
            "Winter is coming",
            "The Kingsroad",
            "Lord Snow",
            "Cripples, Bastards, and Broken Things",
            "The Wolf and the Lion",
            "A Golden  Crown",
            "You Win or you Die",
            "The Point End",
            "Baelor",
            "Fire and Blood"
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_episode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        LayoutInflater inflater= (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listView = (ListView) findViewById(R.id.listView);

        View vi= inflater.inflate(R.layout.episode_item, null);
        listView.setAdapter(new EpisodesAdapter(this, values));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.episode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    ListView listView ;


    public class EpisodesAdapter extends ArrayAdapter<String> {
        public EpisodesAdapter(Context context, List<String> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.episode_item, parent, false);

            TextView episodeNumber = (TextView) convertView.findViewById(R.id.episode_number);
            TextView episodeTitle = (TextView) convertView.findViewById(R.id.episode_title);
            episodeNumber.setText("E"+ (position+1));
            episodeTitle.setText(getItem(position));
            return convertView;
        }
    }
}
