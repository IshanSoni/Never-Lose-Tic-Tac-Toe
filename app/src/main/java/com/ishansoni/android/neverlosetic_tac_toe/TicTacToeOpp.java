
package com.ishansoni.android.neverlosetic_tac_toe;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeOpp extends AppCompatActivity {
    private Button[][] board;
    private TextView hint;
    private TextView enemyPos;
    private TextView enemyPosSpecify;
    private int oppRow;
    private int oppCol;
    private Integer playerRow;
    private Integer playerCol;
    private Typeface typeFace;
    private TextView myTextView;

    private void updateOpponentMove(int r, int c) {
        oppRow = r;
        oppCol = c;
        board[oppRow][oppCol].setText(R.string.o);
        setFont(board[r][c].getId());
        board[r][c].setTextColor(Color.BLUE);
    }

    private void updatePlayerMove(int r, int c) {
        setFont(board[r][c].getId());

        board[playerRow][playerCol].setTextColor(Color.BLUE);
        board[playerRow][playerCol].setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        board[playerRow][playerCol].setText(R.string.x);

        board[r][c].setTextColor(Color.RED);
        board[r][c].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        board[r][c].setText(R.string.here);

        enemyPos.setText(R.string.enemy_pos);
        //enemyPosSpecify.setText(R.string.enemy_spec);
        hint.setText("Plan your next move at position "+(r+1)+","+(c+1)+" (indicated below) to avoid any possible traps");
        playerRow = r;
        playerCol = c;

        /* Sets all buttons to display warning message when pressed, which
           later allows all the used spots on the board to display that also. */
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TicTacToeOpp.this, R.string.invalid_move, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void tie() { //handles textview if the round is tie
        //disables all buttons
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TicTacToeOpp.this, R.string.tie_toast, Toast.LENGTH_SHORT).show();
                    }
                });

        hint.setText(R.string.tie);
        enemyPos.setText(R.string.tie_opp);
        enemyPosSpecify.setText(R.string.tie_opp_note);

    }

    private void tieEdge() { //handles textview if the opponent moves edge
        //disables all buttons
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TicTacToeOpp.this, R.string.tie_toast, Toast.LENGTH_SHORT).show();
                    }
                });

        hint.setText(R.string.tie_opp_edge);
        enemyPos.setText(R.string.tie_opp_edge_endorsed);
        enemyPosSpecify.setText(R.string.tie_opp_edge_note);
    }

    private void setFont(int id) {
        typeFace= Typeface.createFromAsset(getAssets(),"fonts/Rancho-Regular.ttf");

        myTextView=(TextView)findViewById(id);
        myTextView.setTypeface(typeFace);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_help);

        board = new Button[][]{{(Button) findViewById(R.id.button6), (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button7)},
                {(Button) findViewById(R.id.button5), (Button) findViewById(R.id.button), (Button) findViewById(R.id.button4)},
                {(Button) findViewById(R.id.button8), (Button) findViewById(R.id.button3), (Button) findViewById(R.id.button9)}};

        hint = (TextView) findViewById(R.id.hint);
        enemyPos = (TextView) findViewById(R.id.enemy_pos);
        enemyPosSpecify = (TextView) findViewById(R.id.enemy_pos_spec);

        setFont(R.id.hint);
        setFont(R.id.enemy_pos);
        setFont(R.id.enemy_pos_spec);

        opponentGoesFirst();

    }

    private void opponentGoesFirst() {   //sets up possibilities if the opponent goes first
        hint.setText(R.string.hint_first_opponent);
        enemyPos.setText(R.string.enemy_pos_first);
        board[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 2;
                playerCol = 0;
                updateOpponentMove(1, 1);
                updatePlayerMove(2, 0);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(1, 2);
                        tie(); //tie
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(1, 0);
                        tie(); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 1);
                        tie(); //tie
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(0, 0);
                        tie(); //tie
                    }
                });

            }
        });

        board[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(0, 0);
                updatePlayerMove(1, 1);

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(0, 2);
                        tie(); //tie
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 1);
                        tie(); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(1, 0);
                        tie(); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

            }
        });

        board[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(0, 1);
                updatePlayerMove(1, 1);

                tieEdge(); //tie
            }
        });

        board[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(0, 2);
                updatePlayerMove(1, 1);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(0, 1);
                        tie(); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(0, 0);
                        tie(); //tie
                    }
                });


                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(1, 2);
                        tie(); //tie
                    }
                });

            }
        });

        board[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(1, 0);
                updatePlayerMove(1, 1);

                tieEdge(); //tie
            }
        });

        board[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(1, 2);
                updatePlayerMove(0, 0);

                tieEdge(); //tie
            }
        });

        board[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(2, 0);
                updatePlayerMove(1, 1);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(1, 0);
                        tie(); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(0, 0);
                        tie(); //tie
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 2);
                        tie(); //tie
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

            }
        });

        board[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(2, 1);
                updatePlayerMove(1, 1);

                tieEdge(); //tie
            }
        });

        board[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRow = 1;
                playerCol = 1;
                updateOpponentMove(2, 2);
                updatePlayerMove(1, 1);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(0, 1);
                        tie(); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(1, 2);
                        tie(); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(0, 2);
                        tie(); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 0);
                        tie(); //tie
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(2, 1);
                        tie(); //tie
                    }
                });

            }
        });
    }

}

