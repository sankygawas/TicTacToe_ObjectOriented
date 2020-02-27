# **Game Verifier for Cross(X) and Noughts(O)**

## Contents

1.	Build, Test, JavaDoc, Run
2.	Design Thought Process
3.	Access Test Results and JavaDoc

### **1.	Build, Test, JavaDoc and Run**
These commands will compile the classes, run the test cases, build the javaDoc and run the program from the console.  Run the below commands from the R3Project folder where the gradle.build file is placed.

* a.	gradle build
* b.	gradle javadoc
* c.	gradle --console plain run 

Play the game by entering the placement by giving positions separated by Enter

### **2.	Design Thought Process**

The components required for this game are a Verifier/Referee, a gameboard/grid composed of cells having value: Empty, X or O, gameState having value: Tie, Playing, X_Win or O_Win, 2 players and their turns. 

As this project is a part of the larger application some of the above-mentioned entities: players, turns, sessions are not implemented, just the core logic of verification, board/grid and a GameRunner is implemented. 

As requested, the Referee class is implemented which acts as a verifier for the game and it’s constructor takes an input of a grid of size N (default to 3x3 grid) which is represented by the Grid class. The referee class implemented in a way that it works for a grid of any size. The getOutCome method is made public and can be used by the higher classes where the session is maintained. The Referee class uses the GameState enum to represent the state of the game and returns this enum values to the callee.

The Grid class is implemented which acts as the encapsulation for the 2D array and the representation of the gameboard. The Grid can take 2D array of Cell class of any size. It consists of private service methods which can make changes on the grid, display the grid and getter for a particular cell in the grid.

The Cell class is implemented which acts as a individual cell in a grid and holds an instance of the CellType enum which has values: Cross, Nought and Empty.

The GameTester is implemented which mimics the game and demonstrate the working of the Verifier class.

### **3.	Access the Test Results and JavaDoc**
Afte running the gradle commands given above, the test results and javadoc are generated and can be accessed in the locations given below
1.	Test: \build\reports\tests\test\index.html
2.	JavaDoc: \build\docs\javadoc\index.html
