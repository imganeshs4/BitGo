package ml.coderuth.bitgo.bit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.nitrico.mapviewpager.MapViewPager;
import com.google.android.gms.maps.SupportMapFragment;

import ml.coderuth.bitgo.R;
import ml.coderuth.bitgo.Utils;


public class BitActivity extends AppCompatActivity implements MapViewPager.Callback {

    private ViewPager viewPager;
    private MapViewPager mvp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit);

        SupportMapFragment map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageMargin(Utils.dp(this, 18));
        Utils.setMargins(viewPager, 0, 0, 0, Utils.getNavigationBarHeight(this));

        mvp = new MapViewPager.Builder(this)
                .mapFragment(map)
                .viewPager(viewPager)
                .position(2)
                .adapter(new BitAdapter(getSupportFragmentManager()))
                .callback(this)
                .build();
    }

    @Override
    public void onMapViewPagerReady() {
        mvp.getMap().setPadding(
                0,
                Utils.dp(this, 40),
                Utils.getNavigationBarWidth(this),
                viewPager.getHeight() + Utils.getNavigationBarHeight(this));
    }

}
