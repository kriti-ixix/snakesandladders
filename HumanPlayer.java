package com.example.helloworld;

import java.util.Scanner;

public class HumanPlayer extends Player
{
    //Request integer input from player (1-6)
    Scanner sc = new Scanner(System.in);

    HumanPlayer(char playerIdentifier)
    {
        super(playerIdentifier);
    }

    @Override
    public boolean move()
    {
        System.out.println("\nInput a move from 1 to 6: ");
        int input = sc.nextInt();
        if (input>6)
        {
            do
            {
                System.out.println("\nIncorrect. Input between 0 and 6 only: ");
                input = sc.nextInt();
            } while(input>6);
        }

        if(playerSquare.position + input > 49)
        {
            return false;
        }

        int oldpos = playerSquare.position;
        playerSquare.updatePlayers(this);
        Board.boardSquares[oldpos] = playerSquare;
        Square newSquare = new Square(oldpos+input);
        playerSquare = newSquare;

//        playerSquare.updatePlayers(this);
//        playerSquare.setPlayer(this);

        //playerSquare.position += count;
        if (playerSquare.delta!=0)
        {
            //Updates value in case of a delta value on the square
            //playerSquare.position += playerSquare.delta;
            oldpos = playerSquare.position;
            newSquare = new Square(oldpos+input);
            playerSquare = newSquare;
            playerSquare.updatePlayers(this);
            playerSquare.setPlayer(this);
        }
        playerSquare.setPlayer(this);
        Board.boardSquares[oldpos+input] = playerSquare;

        System.out.println("\nHuman player's positon: "+playerSquare.position);
        //Checking player's final position after moving
        if (playerSquare.position == 49)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}