package com.ishansoni.android.neverlosetic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TicTacToeHelp extends AppCompatActivity {
    private ImageButton[][] board;
    private TextView hint;
    private TextView enemyPos;
    private int oppRow;
    private int oppCol;
    private int playerRow;
    private int playerCol;

    private void updateOpponentMove(int r, int c) {
        //if(board[r][c].get().equals("")) {
            oppRow = r;
            oppCol = c;
            board[oppRow][oppCol].setImageResource(R.drawable.o);
        //}
    }

    private void updatePlayerMove(int r, int c) {
        board[playerRow][playerCol].setImageResource(R.drawable.x);
        board[r][c].setImageResource(R.drawable.here);
        enemyPos.setText(R.string.enemy_pos);
        hint.setText("Move to "+ r + ", "+ c);
        playerRow = r;
        playerCol = c;
    }

    public void win(int r, int c) {
        board[r][c].setImageResource(R.drawable.win);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_help);

        board = new ImageButton[][]{{(ImageButton) findViewById(R.id.button6), (ImageButton) findViewById(R.id.button2), (ImageButton) findViewById(R.id.button7)},
                               {(ImageButton) findViewById(R.id.button5), (ImageButton) findViewById(R.id.button), (ImageButton) findViewById(R.id.button4)},
                               {(ImageButton) findViewById(R.id.button8), (ImageButton) findViewById(R.id.button3), (ImageButton) findViewById(R.id.button9)}};
        hint = (TextView) findViewById(R.id.hint);
        enemyPos = (TextView) findViewById(R.id.enemy_pos);

        playerGoesFirst();

    }

    private void playerGoesFirst() {//sets up possiblities/counters if the player goes first
        playerRow = 1;
        playerCol = 1;
        updatePlayerMove(1,1);
        board[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(0, 0);
                updatePlayerMove(2, 2);

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(0, 2);
                        win(1, 2);
                        win(2, 0); //win 1,2 or 2,0
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 1); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 0);
                        win(0, 2);
                        win(2, 1); //win 0,2 or 2,1
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 0);
                        win(0, 2);
                        win(2, 1); //win 0,2 or 2,1
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(1, 0); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 2);
                        win(1, 2);
                        win(2, 0); //win 1,2 or 2,0
                    }
                });

            }
        });

        board[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(0, 1);
                updatePlayerMove(2, 0);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        win(0, 2); //win 0,2
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 0);
                        win(1,0);
                        win(2, 2); //win 1,0 or 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        win(0, 2); //win 0,2
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        win(0, 2); //win 0,2
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        win(0, 2); //win 0,2
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        win(0, 2); //win 0,2
                    }
                });
            }
        });

        board[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(0, 2);
                updatePlayerMove(2, 0);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(0, 1); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(0, 0);
                        win(1, 0);
                        win(2, 2); //win 1,0 or 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 2);
                        win(0, 0);
                        win(2, 1); //win 0,0 or 2,1
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 2);
                        win(0, 0);
                        win(2, 1); //win 0,0 or 2,1
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 0);
                        win(1, 0);
                        win(2, 2); //win 1,0 or 2,2
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(1, 2); //tie
                    }
                });

            }
        });

        board[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(1, 0);
                updatePlayerMove(2, 2);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(2, 0);
                        win(0, 2);
                        win(2, 1); //win 0,2 or 2,1
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        win(0, 0); //win 0,0
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        win(0, 0); //win 0,0
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        win(0, 0); //win 0,0
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        win(0, 0); //win 0,0
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        win(0, 0); //win 0,0
                    }
                });
            }
        });

        board[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(1, 2);
                updatePlayerMove(0, 0);

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(0, 2);
                        win(0, 1);
                        win(2, 0); //win 0,1 or 2,0
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        win(2, 2); //win 2,2
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        win(2, 2); //win 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        win(2, 2); //win 2,2
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        win(2, 2); //win 2,2
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        win(2, 2); //win 2,2
                    }
                });
            }
        });

        board[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(2, 0);
                updatePlayerMove(0, 2);

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        updatePlayerMove(1, 0); //tie
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(2, 2);
                        win(0, 0);
                        win(1, 2); //win 0,0 or 1,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(0, 0);
                        win(0, 1);
                        win(2, 2); //win 0,1 or 2,2
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(0, 0);
                        win(0, 1);
                        win(2, 2); //win 0,1 or 2,2
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 2);
                        win(0, 0);
                        win(1, 2); //win 0,0 or 1,2
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        updatePlayerMove(2, 1); //tie
                    }
                });

            }
        });

        board[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(2, 1);
                updatePlayerMove(0, 2);

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(2, 2);
                        win(0, 0);
                        win(1, 2); //win 0,0 or 1,2
                    }
                });

                board[0][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 0);
                        win(2, 0); //win 2,0
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        win(2, 1); //win 2,1
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        win(2, 1); //win 2,1
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        win(2, 1); //win 2,1
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        win(2, 1); //win 2,1
                    }
                });
            }
        });

        board[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpponentMove(2, 2);
                updatePlayerMove(0, 0);

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        updatePlayerMove(2, 0);
                        win(1, 0);
                        win(0, 2); //win 1,0 or 0,2
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(1, 2); //tie
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(0, 2);
                        win(0, 1);
                        win(2, 0); //win 0,1 or 2,0
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(0, 2);
                        win(0, 1);
                        win(2, 0); //win 0,1 or 2,0
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(2, 1); //tie
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(2, 0);
                        win(1, 0);
                        win(0, 2); //win 1,0 or 0,2
                    }
                });

            }
        });

    }

}

