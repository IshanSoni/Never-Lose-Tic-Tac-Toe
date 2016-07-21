package com.ishansoni.android.neverlosetic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class TicTacToeHelp extends AppCompatActivity {
    private Button[][] board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_help);

        board = new Button[][] {{(Button)findViewById(R.id.button6),(Button)findViewById(R.id.button2),(Button)findViewById(R.id.button7)},
        {(Button)findViewById(R.id.button5),(Button)findViewById(R.id.button),(Button)findViewById(R.id.button4)},
        {(Button)findViewById(R.id.button8),(Button)findViewById(R.id.button3),(Button)findViewById(R.id.button9)}};





    }
}
