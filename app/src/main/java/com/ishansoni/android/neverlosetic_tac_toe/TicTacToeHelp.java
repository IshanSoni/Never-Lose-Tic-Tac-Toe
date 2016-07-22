package com.ishansoni.android.neverlosetic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TicTacToeHelp extends AppCompatActivity {
    private Button[][] board;
    private int oppRow;
    private int oppCol;

    private void updateOpponentMove() {

        board[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[0][0].getText().equals("")) {
                    oppRow = 0;
                    oppCol = 0;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[0][1].getText().equals("")) {
                    oppRow = 0;
                    oppCol = 1;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[0][2].getText().equals("")) {
                    oppRow = 0;
                    oppCol = 2;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[1][0].getText().equals("")) {
                    oppRow = 1;
                    oppCol = 0;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[1][1].getText().equals("")) {
                    oppRow = 1;
                    oppCol = 1;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[1][2].getText().equals("")) {
                    oppRow = 1;
                    oppCol = 2;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[2][0].getText().equals("")) {
                    oppRow = 2;
                    oppCol = 0;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[2][1].getText().equals("")) {
                    oppRow = 2;
                    oppCol = 1;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

        board[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[2][2].getText().equals("")) {
                    oppRow = 2;
                    oppCol = 2;
                    board[oppRow][oppCol].setText(R.string.o);
                }
            }
        });

    }

    private void updatePlayerMove(int r, int c) {
        board[r][c].setText(R.string.x);
    }

    private boolean opponentMovedCorner() {
        if ((oppRow == 0 || oppRow == 2) &&    //opponent moves corner
            (oppCol == 0 || oppCol == 2))
            return true;
        else
            return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_help);

        board = new Button[][] {{(Button)findViewById(R.id.button6),(Button)findViewById(R.id.button2),(Button)findViewById(R.id.button7)},
                                {(Button)findViewById(R.id.button5),(Button)findViewById(R.id.button),(Button)findViewById(R.id.button4)},
                                {(Button)findViewById(R.id.button8),(Button)findViewById(R.id.button3),(Button)findViewById(R.id.button9)}};

        updateOpponentMove();
        if(opponentMovedCorner()) {
            updatePlayerMove((oppRow+2) %4, (oppCol+2) %4);
            updateOpponentMove();

        }

    }
}
