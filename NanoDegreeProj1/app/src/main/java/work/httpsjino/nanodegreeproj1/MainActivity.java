package work.httpsjino.nanodegreeproj1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.sliderView);

        SliderAdapter viewPagerAdapter = new SliderAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 4000,6000);
    }

    /**
     * This method is called when website or map-address of business is clicked
     * @param view This is the view which was clicked by user
     */
    public void contactUs(View view) {
        switch (view.getId()) {
            case R.id.business_website:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://jino.work")));
                break;

            case R.id.business_mob:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel: +91-9746785785")));
                break;

            case R.id.business_address:
                Intent openBusinessOnMaps = new Intent(Intent.ACTION_VIEW);
                openBusinessOnMaps.setData(Uri.parse("geo:8.8831872,76.6731672"));

                if (openBusinessOnMaps.resolveActivity(getPackageManager()) != null)
                    startActivity(openBusinessOnMaps);
                break;
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem() == 4) {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
