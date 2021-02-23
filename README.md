In this AE you will create the classes required for a Snakes and Ladders game.

Stage 1: The Player and Square classes

A board will consist of an array of Square objects. Consider this board:

https://i.stack.imgur.com/pewAY.jpg

It has 10 rows and 5 columns. The starting square (0) is drawn in the bottom left. The
winning position is 49 (top left). There are two players ‘E’ and ‘S’. ‘S’ is at position 35 and ‘E’
at position 28.

Each Square object consists of:

- an integer position (0 to 49),
- references to any Player objects that are currently at that square and
- aninteger delta.

The integer delta _ indicates how far up or down the player should move if they land here
(a positive number indicates a ladder — see for example, position 18, and a negative number
denotes a snake — see for example position 32). If there is no snake or ladder starting at a
square, delta = 0. Square objects need a set Delta method.

Squares should have a toString method that returns a string representation of the
square consisting of player information (from the toString method) for all players
currently at the square, the square position, and the value of delta in brackets (if delta
is not zero).

Players have an attribute of type char that allows them to be identified. In the example
above, these are ‘E’ and ‘S’. The toString method of the Player class just returns this
as a string.

To make things easier later on, Player objects should hold a reference to the square in
which they are currently located.

Task1: create Player and Square classes that admit the functionality described above.
In your Player class, include amain method that demonstrates the creation of a player,
the creation of a square, the assignment of the Player tothe Square, and the
toString methods of both the player and the square.
 

Stage 2: The Board class

The Board constructor should take integers representing the number of rows and columns.
Players always start at position 0. The board should always be drawn so that the row
containing the final position (49 in our example) is the top and the starting row (containing
0) is at the bottom. The board should have an attribute that is an array of Square objects.
A Board object should also store references to all players playing the game. When a player
is added to the game they should be placed in the square at position 0.

The board should have a toString method that returns a string representation of the
board (making use of the toString method of the Square class).

The Board class should have helper methods that return the row and column of a
particular position, and the position corresponding to a particular row, column pair.

The Board class should have a method for adding players. When players are added, the
board should store a reference to them for future use and place them on the starting
square.

The Board class should have a method that returns a reference to the Square object at
any integer position.

The rows of the board should wrap (see example above). i.e. when a player reaches the
end of a row, their next square should be immediately above them.

Task 2: create a Board class that admits this functionality. In the Board class, include a
main method that creates a board with 10 rows and 5 columns. The main method should
also create two players, add them to the board, and print the board.


Stage 3: Moving

Now we start to play! Players should be given a move method. It should return a binary
value which will be t rue if the move they make results in winning, and false otherwise.
The move method will roll a die (example below) and move the player forward the relevant
number of places. If a player’s move ends up on a square with a delta, they should move
forward or backward by the relevant number of spaces.

Task 3: Add move methods to the players and a method to the board (takeTurns) that
loops through the players and calls each of their move methods. If a move method returns
true, that player has won and takeTurns should immediately terminate, returning
true. Otherwise it should return false.


Stage 4: Playing

Task 4: Create a new class (Play. java) that will contain a main method that will create a
board, some players and start a game, playing it until completion. In thismain method add
deltas to some of the squares (at least two snakes, and two ladders). Ensure that no snake
or ladder ends where another snake or ladder starts (this can result in an infinite loop).
 

Stage 5: Different types of player

Task 5: Create a subclass of your Player class (call it HumanPlayer) that, when the
move method is called, writes a message to the standard output requesting an input integer
and then waits until the player enters an integer between 1 and 6. (you might find this
useful for testing other tasks). Show this player being used in the main method of your
Play class.
