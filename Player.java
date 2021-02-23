package com.example.helloworld;

import java.util.Random;

public class Player
{
    char playerIdentifier;
    //playerIdentifier in this example is either E or S

    //Reference to square
    Square playerSquare;

    Player(char playerIdentifier)
    {
        this.playerIdentifier = playerIdentifier;
    }

    void setPlayerSquare(Square playerSquare)
    {
        this.playerSquare = playerSquare;
    }

    //toString method to return the player character
    public String toString()
    {
        return String.valueOf(playerIdentifier);
    }

    //Move method to check if the player's move lead to a win or not
    public boolean move()
    {
        //Rolling a die and moving according to delta value
        Random r = new Random();
        int count = r.nextInt(6)+1; //To get values between 1 and 6

        String winner = "Winner is: ";

        //Updates player's position according to the dice value
        if(playerSquare.position + count > 49)
        {
            return false;
        }

        int oldpos = playerSquare.position;
        playerSquare.updatePlayers(this);
        Board.boardSquares[oldpos] = playerSquare;
        Square newSquare = new Square(oldpos+count);
        playerSquare = newSquare;

//        playerSquare.updatePlayers(this);
//        playerSquare.setPlayer(this);

        //playerSquare.position += count;
        if (playerSquare.delta!=0)
        {
            //Updates value in case of a delta value on the square
            //playerSquare.position += playerSquare.delta;
            oldpos = playerSquare.position;
            newSquare = new Square(oldpos+count);
            playerSquare = newSquare;
            playerSquare.updatePlayers(this);
            playerSquare.setPlayer(this);
        }
        playerSquare.setPlayer(this);
        Board.boardSquares[oldpos+count] = playerSquare;

        System.out.println("\nComputer player's positon: "+playerSquare.position);

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

    //main method
    //Creation of player and square
    public static void main(String[] args) {
        //Create an arraylist of player
        Player pe = new Player('E');
        Player ps = new Player('S');
    }
}