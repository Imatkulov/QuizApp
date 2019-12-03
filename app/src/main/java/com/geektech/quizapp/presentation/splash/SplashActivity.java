package com.geektech.quizapp.presentation.splash;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.geektech.quizapp.R;
import com.geektech.quizapp.presentation.main.MainActivity;

public class SplashActivity extends AppCompatActivity {
    private long mills = 1000;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.img_splash);
        setSplashTime();
    }

    private void setSplashTime() {
        new CountDownTimer(mills, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mills = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                getMainActivity();
            }
        }.start();
    }

    private void getMainActivity() {
        MainActivity.start(this);
        finish();
    }
}
