package kerolos.magdy.xvso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class splash extends AppCompatActivity {
    Animation logoAnim;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgLogo = findViewById(R.id.img_logo);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(splash.this, MainActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent);
                    finish();
                } else{
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(splash.this, (View)imgLogo, ViewCompat.getTransitionName(imgLogo));
                    startActivity(intent, options.toBundle());
                    finish();
                }
            }
        },4000);



        YoYo.with(Techniques.BounceIn)
                .duration(3000)
                .repeat(0)
                .playOn(findViewById(R.id.img_logo));

        YoYo.with(Techniques.ZoomInUp)
                .duration(2000)
                .repeat(0)
                .playOn(findViewById(R.id.txtName1));

        YoYo.with(Techniques.ZoomInUp)
                .duration(2000)
                .repeat(0)
                .playOn(findViewById(R.id.txtName2));

//        logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_anim);
//        imgLogo = findViewById(R.id.img_logo);
//        imgLogo.setAnimation(logoAnim);
    }
}