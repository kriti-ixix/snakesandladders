package com.example.helloworld;

public class Play
{
    public static void main(String[] args)
    {
        //Creating a board
        System.out.println("Creating a board...");
        Board board = new Board(10, 5);

        //Creating players and adding them to the arraylist
        System.out.println("Adding two players...");
        Player ePlayer = new Player('E');
        ePlayer.setPlayerSquare(board.boardSquares[0]);
        board.addPlayer(ePlayer);
        HumanPlayer sPlayer = new HumanPlayer('S');
        sPlayer.setPlayerSquare(board.boardSquares[0]);
        board.addPlayer(sPlayer);

        System.out.println("Time to start the game!");
        //Print out board
        do
        {
            board.printBoard();
        }
        while(!board.takeTurns());

    }
}
