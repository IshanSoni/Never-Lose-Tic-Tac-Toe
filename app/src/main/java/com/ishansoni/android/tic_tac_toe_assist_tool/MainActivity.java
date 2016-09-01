package com.ishansoni.android.tic_tac_toe_assist_tool;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private RadioGroup buttons;
    private RadioButton player;
    private RadioButton opponent;
    private Button start;
    private int choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-4117140826445508/2240462267");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface typeFace= Typeface.createFromAsset(getAssets(),"fonts/Rancho-Regular.ttf");

        TextView myTextView=(TextView)findViewById(R.id.first_player);
        myTextView.setTypeface(typeFace);

        myTextView=(TextView)findViewById(R.id.logo_1);
        myTextView.setTypeface(typeFace);

        myTextView=(TextView)findViewById(R.id.logo_2);
        myTextView.setTypeface(typeFace);

        myTextView=(TextView)findViewById(R.id.player_win);
        myTextView.setTypeface(typeFace);

        myTextView=(TextView)findViewById(R.id.opp_tie);
        myTextView.setTypeface(typeFace);

        buttons = (RadioGroup) findViewById(R.id.radio_group);
        buttons.clearCheck();

        player = (RadioButton) findViewById(R.id.player_button);
        player.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) choice = 1;
                else choice = 0;
            }
        });
        opponent = (RadioButton) findViewById(R.id.enemy_button);
        opponent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) choice = 2;
                else choice = 0;
            }
        });

        start = (Button)findViewById(R.id.start);
        myTextView=(TextView)findViewById(R.id.start);
        myTextView.setTypeface(typeFace);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(choice == 1) {
                    Intent i = new Intent(MainActivity.this, TicTacToeHelp.class);
                    startActivity(i);
                }
                else if(choice == 2) {
                    Intent i = new Intent(MainActivity.this, TicTacToeOpp.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select who goes first", Toast.LENGTH_SHORT).show();
                }
                buttons.clearCheck();
            }
        });

    }
}
