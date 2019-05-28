package sanchezartega.facci.rencaronline.Slide;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import sanchezartega.facci.rencaronline.Login.ui.login.LoginActivity;
import sanchezartega.facci.rencaronline.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    private int[] layouts = new int[]{R.layout.welcome_slide1, R.layout.welcome_slide2, R.layout.welcome_slide3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        if (!PrefManager.shouldShowSlider()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);

        setBtnClickListener(R.id.btn_got_it);
        setBtnClickListener(R.id.btn_next);
        setBtnClickListener(R.id.btn_skip);

        // adding bottom dots
        addBottomDots();
        // By default, select dot in the first position
        updateBottomDots(0, 0);

        viewPager.setAdapter(new MyViewPagerAdapter());
        viewPager.addOnPageChangeListener(pageChangeListener);
    }

    private void setBtnClickListener(int id) {
        Button button = (Button) findViewById(id);
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    private void showHideView(int id, int visibility) {
        View view = findViewById(id);
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    private void launchHomeScreen() {
        PrefManager.saveFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        finish();
    }

    private void addBottomDots() {
        if ((dotsLayout == null) || (layouts == null))
            return;

        int dotSize = layouts.length;
        dotsLayout.removeAllViews();

        dots = new TextView[dotSize];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
    }

    private void updateBottomDots(int prevPosition, int curPosition) {
        if (dots == null)
            return;

        int dotLength = dots.length;
        if ((dotLength > prevPosition) && (dotLength > curPosition)) {
            dots[prevPosition].setTextColor(getResources().getColor(R.color.dot_dark_screen1));
            dots[curPosition].setTextColor(getResources().getColor(R.color.dot_light_screen1));
        }
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        int prevPos = 0;

        @Override
        public void onPageSelected(int position) {

            updateBottomDots(prevPos, position);

            boolean isLastPage = (position == (layouts.length - 1));
            showHideView(R.id.btn_next, isLastPage ? View.GONE : View.VISIBLE);
            showHideView(R.id.btn_skip, isLastPage ? View.GONE : View.VISIBLE);
            showHideView(R.id.btn_got_it, isLastPage ? View.VISIBLE : View.GONE);

            prevPos = position;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
            case R.id.btn_got_it:
                launchHomeScreen();
                break;
            case R.id.btn_next:
                showNextSlide();
                break;
        }
    }

    private void showNextSlide() {
        // Checking for last page
        // If last page home screen will be launched
        int nextIndex = viewPager.getCurrentItem() + 1;
        if ((viewPager != null) && (nextIndex < layouts.length)) {
            viewPager.setCurrentItem(nextIndex);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return (layouts != null) ? layouts.length : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return (view == obj);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
