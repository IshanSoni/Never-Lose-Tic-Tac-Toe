package com.ishansoni.android.neverlosetic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
