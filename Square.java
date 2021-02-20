package com.example.helloworld;

import java.util.ArrayList;

public class Square
{
    //Position of the current square
    int position;
    //References to any Player objects at that square

    //Keeping track of how far up or down a player should move
    int delta = 0; //0 when no snake or ladder at the current square

    //Getting information about the player(s) at the current square
    //Ask about this keyword to create a reference
    ArrayList<Player> players = new ArrayList<>();
    //Board board = new Board();

    public Square(int position)
    {
        this.position = position;
        delta = setDelta(position);
    }

    public void setPlayer(Player player)
    {
        players.add(player);
    }

    //setDelta method using position of the square
    int setDelta(int position)
    {
        int currentDelta;

        //Switch statement to set the delta value of the current square
        switch (position)
        {
            case 15:
                currentDelta = -1;
                break;
            case 18:
                currentDelta = 4;
                break;
            case 29:
                currentDelta = -4;
                break;
            case 30:
                currentDelta = -1;
                break;
            case 32:
                currentDelta = -4;
                break;
            case 33:
                currentDelta = 2;
                break;
            case 34:
                currentDelta = -1;
                break;
            case 48:
                currentDelta = -3;
                break;

            default:
                currentDelta = 0;
        }

        return currentDelta;
    }

    public String toString()
    {
        //Initialising the string to return
        String playerInfo=" ";
        for(Player player:players)
        {
            playerInfo += player.toString()+" ";
        }

        //Creating the string to return to the main method
        //String playerInfo includes current square position, the player(s) at it and
        //the delta value of the it
        String s = playerInfo + " " + position + "( " + (delta==0?"  ": String.valueOf(delta)) + " )";
        return s;
    }
}
