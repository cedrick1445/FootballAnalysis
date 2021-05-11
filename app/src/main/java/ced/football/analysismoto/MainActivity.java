package ced.football.analysismoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import ced.football.analysismoto.fragments.FourFragment;
import ced.football.analysismoto.fragments.OneFragment;
import ced.football.analysismoto.fragments.ThreeFragment;
import ced.football.analysismoto.fragments.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView andar_image, rules_image, guide_image, payout_image;
    private CardView btn_back;
    private MotionLayout motion_layout;
    private int lastEndTransition = R.id.endFirst;
    private final int TAB_SLIDE_ANIM = 1;
    private final int TAB_REARRANGEMENT_ANIM = 0;
    private int currentAnim = TAB_REARRANGEMENT_ANIM;
    private int transitionTabIndex = 0;
    private ViewPager viewPager;
    private int exitCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initInstruction();
        initAdapter();
        initOnListener();
    }

    private void init() {
        motion_layout = findViewById(R.id.motion_layout);
        btn_back = findViewById(R.id.btn_back);
        andar_image = findViewById(R.id.live_image);
        rules_image = findViewById(R.id.matches_image);
        guide_image = findViewById(R.id.players_image);
        payout_image = findViewById(R.id.leagues_image);
        viewPager = findViewById(R.id.viewPager);
    }

    private void initInstruction() {
        new ShowcaseView.Builder(MainActivity.this)
                .setTarget( new ViewTarget( (findViewById(R.id.live_image))))
                .setContentTitle("About")
                .setContentText("Click the views to see the information of the game Football.")
                .hideOnTouchOutside()
                .build();
    }

    private void initAdapter() {
        ViewPageeer viewPageeer = new ViewPageeer(getSupportFragmentManager());

        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        FourFragment fourFragment = new FourFragment();

        viewPageeer.addFragment(oneFragment, "");
        viewPageeer.addFragment(twoFragment, "");
        viewPageeer.addFragment(threeFragment, "");
        viewPageeer.addFragment(fourFragment, "");
        viewPager.setAdapter(viewPageeer);
    }

    private void initOnListener() {
        motion_layout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {

            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {
                if (currentAnim == TAB_REARRANGEMENT_ANIM && motion_layout.getProgress() == 1f && transitionTabIndex != 0) {
                    currentAnim = TAB_SLIDE_ANIM;
                    setCurrentTab();
                }
            }
        });

        btn_back.setOnClickListener(e -> {
            if (currentAnim == TAB_SLIDE_ANIM) {
                currentAnim = TAB_REARRANGEMENT_ANIM;
                motion_layout.setTransition(R.id.start, lastEndTransition);
                motion_layout.setProgress(1f);
                motion_layout.setTransitionDuration(1000);
                motion_layout.transitionToStart();
            } else {
                MainActivity.this.exitApp();
            }
        });
        andar_image.setOnClickListener(view -> {
            if (currentAnim == TAB_REARRANGEMENT_ANIM) {
                lastEndTransition = R.id.endFirst;
                motion_layout.setTransition(R.id.start, R.id.endFirst);
                motion_layout.setTransitionDuration(1000);
                motion_layout.transitionToEnd();
                transitionTabIndex = 0;
                setCurrentTab();
                currentAnim = TAB_SLIDE_ANIM;

            }
        });
        rules_image.setOnClickListener(view -> {
            if (currentAnim == TAB_REARRANGEMENT_ANIM) {
                lastEndTransition = R.id.endSecond;
                motion_layout.setTransition(R.id.start, R.id.endSecond);
                motion_layout.setTransitionDuration(1000);
                motion_layout.transitionToEnd();

                transitionTabIndex = 1;
                setCurrentTab();
                currentAnim = TAB_SLIDE_ANIM;

            }
        });
        guide_image.setOnClickListener(view -> {
            if (currentAnim == TAB_REARRANGEMENT_ANIM) {
                lastEndTransition = R.id.endThird;
                motion_layout.setTransition(R.id.start, R.id.endThird);
                motion_layout.setTransitionDuration(1000);
                motion_layout.transitionToEnd();

                transitionTabIndex = 2;
                setCurrentTab();
                currentAnim = TAB_SLIDE_ANIM;
            }
        });
        payout_image.setOnClickListener(view -> {
            if (currentAnim == TAB_REARRANGEMENT_ANIM) {
                lastEndTransition = R.id.endFourth;
                motion_layout.setTransition(R.id.start, R.id.endFourth);
                motion_layout.setTransitionDuration(1000);
                motion_layout.transitionToEnd();

                transitionTabIndex = 3;
                setCurrentTab();
                currentAnim = TAB_SLIDE_ANIM;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (currentAnim == TAB_SLIDE_ANIM) {
                    float newProgress = (position + positionOffset) / 3;

                    motion_layout.setTransition(R.id.startTab, R.id.endTab);
                    motion_layout.setProgress(newProgress);
                }

                transitionTabIndex = position;
                switch (transitionTabIndex) {
                    case 0:
                        lastEndTransition = R.id.endFirst;
                        break;
                    case 1:
                        lastEndTransition = R.id.endSecond;
                        break;
                    case 2:
                        lastEndTransition = R.id.endThird;
                        break;
                    case 3:
                        lastEndTransition = R.id.endFourth;
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setCurrentTab(){
        viewPager.setCurrentItem(transitionTabIndex, false);
    }

    private void exitApp(){
        if (exitCounter == 0) {
            exitCounter = 1;
            Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
        } else {
            super.finishAffinity();
        }
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }
}
