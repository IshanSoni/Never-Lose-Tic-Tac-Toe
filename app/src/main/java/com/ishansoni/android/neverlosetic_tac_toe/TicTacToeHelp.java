package com.ishansoni.android.neverlosetic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TicTacToeHelp extends AppCompatActivity {
    private Button[][] board;
    private int oppRow;
    private int oppCol;
    private int playerRow;
    private int playerCol;
    private int timesRotated;

    private void updateOpponentMove(int r, int c) {
        if(board[r][c].getText().equals("")) {
            oppRow = r;
            oppCol = c;
            board[oppRow][oppCol].setText(R.string.o);
        }
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

    public String[][] rotatePlus90(String[][] beforeRotation)
    {
        timesRotated++;
        String[][] rotated = new String[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                rotated[i][j] = beforeRotation[2-j][i];
        return rotated;
    }

    public void originalPos(int r, int c)  //returns original position if board was rotated
    {
        if (timesRotated > 0)
        {
            int temp;
            int tempTimesRotated = timesRotated;
            while(tempTimesRotated > 0)
            {
                temp = r;
                r = 2-c;
                c = temp;
                tempTimesRotated--;
            }
        }
        playerRow = r;
        playerCol = c;
    }

    private void opponentMovesCorner() {
        if(opponentMovedCorner()) {   //OPP MOVES CORNER AFTER PLAYER MOVES CENTER
            updatePlayerMove((oppRow+2) %4, (oppCol+2) %4);
            board[0][0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(board[0][0].getText().equals("")) {
                        oppRow = 0;
                        oppCol = 0;
                        board[oppRow][oppCol].setText(R.string.o);
                    }

                  /*  String[][] rotatedBoard = new String[3][3];
                    for(int i = 0; i < 3; i++)
                        for(int j = 0; j < 3; j++)
                            rotatedBoard[i][j] = (String) board[i][j].getText();

                    if (!board[2][0].getText().equals(R.string.o)) {   //rotates the original board to default
                        while (!rotatedBoard[2][0].equals(R.string.o)) //to find counter moves easily
                            rotatedBoard = rotatePlus90(rotatedBoard);
                    } */

                    if(opponentMovedCorner()) {   //OPP MOVES CORNER AFTER MOVING CORNER
                        //if(rotatedBoard[0][0].equals(R.string.o)) {
                        if(board[0][0].getText().equals("O")) {
                            playerRow = 1;
                            playerCol = 0;
                        } else {
                            playerRow = 2;
                            playerCol = 1;
                        }
                        //originalPos(playerRow, playerCol); //returns original position if board was rotated
                        updatePlayerMove(playerRow, playerCol);

                    } else {                     //OPP MOVES EDGE AFTER MOVING CORNER

                    }
                }

            });
        };
    }

    private void playerMovesFirst() {
        board[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(board[2][0].getText().equals("")) {
                    oppRow = 2;
                    oppCol = 0;
                    board[oppRow][oppCol].setText(R.string.o);
                }
                opponentMovesCorner();
            }
        });


        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_help);

        board = new Button[][]{{(Button) findViewById(R.id.button6), (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button7)},
                {(Button) findViewById(R.id.button5), (Button) findViewById(R.id.button), (Button) findViewById(R.id.button4)},
                {(Button) findViewById(R.id.button8), (Button) findViewById(R.id.button3), (Button) findViewById(R.id.button9)}};

        board[1][1].setText(R.string.x);
        playerGoesFirst();

    }

    private void playerGoesFirst() {
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
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 1);
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 0);
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 0);
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(1, 0);
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 2);
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
                        //win 0,2
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 0); //win 1,0 or 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        //win 0,2
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        //win 0,2
                    }
                });

                board[2][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 2);
                        //win 0,2
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        //win 0,2
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
                        updatePlayerMove(0, 0); //win 1,0 or 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 2); //win 0,0 or 2,1
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 2); //win 0,0 or 2,1
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 0); //win 1,0 or 2,2
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
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        updatePlayerMove(0, 1);
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        updatePlayerMove(2, 0);
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        updatePlayerMove(2, 0);
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        updatePlayerMove(1, 0);
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        updatePlayerMove(0, 2);
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
                        updatePlayerMove(2, 0); //win 0,2 or 2,1
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        //win 0,0
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        //win 0,0
                    }
                });

                board[1][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 2);
                        //win 0,0
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        //win 0,0
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        //win 0,0
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
                        updatePlayerMove(0, 2); //win 0,1 or 2,0
                    }
                });

                board[0][2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 2);
                        //win 2,2
                    }
                });

                board[0][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(0, 1);
                        //win 2,2
                    }
                });

                board[1][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(1, 0);
                        //win 2,2
                    }
                });

                board[2][0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 0);
                        //win 2,2
                    }
                });

                board[2][1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateOpponentMove(2, 1);
                        //win 2,2
                    }
                });
            }
        });

    }

}

