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

        //Updates player's position according to the entered value
        if(playerSquare.position + input > 49){
            return false;
        }
        playerSquare.position += input;
        System.out.println("human player pos "+playerSquare.position);
        if (playerSquare.delta!=0)
        {
            //Updates value in case of a delta value on the square
            playerSquare.position += playerSquare.delta;
        }

        System.out.println("Human player's position: " + playerSquare.position);

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
