package com.example.helloworld;

import java.util.ArrayList;

public class Board
{
    //Array of square objects
    Square[] boardSquares;
    int rows, columns;
    //Arraylist to store players
    ArrayList<Player> playersList = new ArrayList<>();

    //Constructor of the Board class
    Board(int rows, int columns)
    {
        this.rows = rows; this.columns = columns;
        boardSquares = new Square[rows*columns];
        for(int i = 0 ; i < rows * columns ; i++)
        {
            Square square = new Square(i);
            boardSquares[i] = square;
        }
    }

    //toString method to return entire board
    public String toString()
    {
        String boardString = boardSquares.toString();
        return boardString;
    }

    //Helper method to return row and column of a row

    //Method to add players
    public void addPlayer(Player playerName)
    {
        playersList.add(playerName);
        boardSquares[playerName.playerSquare.position].setPlayer(playerName);
    }

    //Method to return reference to the mentioned Square object
    public Square getSquareInfo(int pos)
    {
        return boardSquares[pos];
    }

    //takeTurns method to loop through all the players and calls their move
    public boolean takeTurns()
    {
        int i=0; boolean win=false;
        //If player wins, this terminates
        while (!win)
        {
            while (i < playersList.size())
            {
                win = playersList.get(i).move();
                printBoard();
                if(win)
                {
                    return true;
                }
                i++;
            }
            i = 0;
        }
        return win;
    }

    public void printBoard()
    {
  
        //Creating 2d array to print out the board
        Square[][] boardMatrix = new Square[rows][columns];

        //To iterate over squares in reverse
        int i = boardSquares.length-1;
        //System.out.println("Total: " + i);

        //Coverting 1d boardSquares array into a 2d matrix
        for (int row=0; row<=9; row++)
        {
            if (row%2==0)
            {
                //System.out.println("\nEven row: " + row);
                //Even number of rows in ascending order
                for (int col = 0; col<5; col++)
                {
                    //System.out.print("Ascending" + col + ' ');
                    boardMatrix[row][col] = boardSquares[i--];
                }
            }
            else
            {
                //System.out.println("\nOdd row: " + row);
                //Odd number of rows in descending order
                for (int col = 4; col>-1; col--)
                {
                    //System.out.print("Descending" + col + ' ');
                    boardMatrix[row][col] = boardSquares[i--];
                }
            }
        }

        //Printing out the board
        for (int r=0; r<10; r++)
        {
            for (int c=0; c<5; c++)
            {
                System.out.print(boardMatrix[r][c]);
            }
            System.out.println();
        }

        /*

        for (int i=49; i>=0; i--)
        {

            if (i%5==0)
            {
                System.out.print(boardSquares[i]);
                System.out.println(' ');
            }
            else
            {
                System.out.print(boardSquares[i]);
            }
        } */
    }

    public static void main(String[] args)
    {
        //Creating board with 10 rows and 5 columns using the class constructor
        Board board = new Board(10, 5);

        //Creating players and adding them to the arraylist
        Player ePlayer = new Player('E');
        board.addPlayer(ePlayer);
        Player sPlayer = new Player('S');
        board.addPlayer(sPlayer);

        //Setting players at the starting position: Square 0
        ePlayer.setPlayerSquare(board.boardSquares[0]);
        sPlayer.setPlayerSquare(board.boardSquares[0]);

        //Print the board
        board.printBoard();
    }

}
