package com.rasel.expendablefloatingactionbar;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_main, fab1_mail, fab3_share, fab2_bookmark;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_main = findViewById(R.id.fab);
        fab1_mail = findViewById(R.id.fab1);
        fab2_bookmark = findViewById(R.id.fab2);
        fab3_share = findViewById(R.id.fab3);

        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);


        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    fab3_share.startAnimation(fab_close);
                    fab2_bookmark.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);

                    fab3_share.setClickable(false);
                    fab2_bookmark.setClickable(false);
                    fab1_mail.setClickable(false);
                    isOpen = false;

                } else {

                    fab3_share.startAnimation(fab_open);
                    fab2_bookmark.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);

                    fab3_share.setClickable(true);
                    fab2_bookmark.setClickable(true);
                    fab1_mail.setClickable(true);
                    isOpen = true;
                }
            }
        });


        fab3_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
            }
        });

        fab1_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
