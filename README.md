## Paper-Rock-Scissors Game ##
This is a command line Maven app and requires Maven to run.

com.turkoglu.Main is the main class to be run.

The main application starts the game immediately and runs in a loop until you select 'Exit'

Main options for the user are 'Paper', 'Rock', 'Scissors', 'Exit'

### The game flow ###

The game is played between a human player and a computer player. You are required to provide
input for each round and also for each round, computer makes a random choice. Based on the rules 
of the game, a winner of the round is decided.

You can stop/exit the game using the 'Exit option', after which the program prints the statistics of 
game showing wins/loses/draws for each player.

A draw happens when both players make the same selection

### Application Logic ###

I've tried to use KISS, DRY and SOLID principles and also made the game extendable. New rules,  
players, methods to provide user input or strategy to make a choice can be added.

According to the general rules of the game, the Selections which wins against others, are coded 
into the logic.

There is a rule engine which executes the rules given to decide the winner of the round.

For the players making a selection, different input methods and strategies are defined according to which 
a sure makes a selection which matches with an enum.

The type of players are also extendable. Currently, there are only human and computer types.

### Testing ###
For each class, there is corresponding test class targeting various edge and main cases of the application.

To run the tests, I've added Junit 5, Mockito dependencies as well as surefire plugin

#### Coverage ####
Currently, there is 93% class, 97% method and 92% line coverage in the tests.