# CSCD349FinalProject
CSCD 349 Final Project

For your final project, you will take the code from the Heroes and Monsters refactoring assignment and add the following features and patterns.

1. Fold the Hero hierarchy so that Hero is a concrete class.  Do the same with the Monster hierarchy.

2. Create a HeroFactory and a MonsterFactory.  These are simple factories that have a createHero and createMonster method, respectively.  The create methods will be passed necessary information for the factory to build an appropriate hero or monster.

3. Utilize the Strategy pattern to build an Attack interface.  Create appropriate concrete classes that represent different ways to attack based on the original specifications of the game.  All DungeonCharacters should utilize the Attack interface.  Use the Flyweight pattern to store a pool of all attacks.  When constructing a hero or monster, an appropriate attack should be assigned from the Flyweight pool.

4.Utilize the Memento pattern to allow the user to save the state of the game.  As part of saving the state, you should write the saved state to a file.  Provide a means to retrieve that state (load a saved game) as part of the game functionality.  Note that using Serialization (Serializable in Java) can make this process very simple.

5. Add (at least) two more heroes and two more monsters to the game.  Assign attributes and behaviors however you wish.

6.Modify the game so that a group of at least three heroes can be chosen by the user.  Duplicate heroes are permissible.  Randomly generate a corresponding number of monsters (once again, duplicates are permissible).  The group of heroes will then battle the group of monsters until one group is defeated.  While not required, you might want to use the Mediator pattern to help manage the battle.  Order of attack and who you can attack in battle is up to you.  More specifically, you can allow the user to choose who attacks first along with whom to attack, or you can automate those actions.

7. The user should be able to replay the game once a battle is finished.

8. The type of interface you use is up to you.  A console interface is fine, but you are welcome to make a GUI version if you wish.  If you choose to make things GUI, don't spend too much time on it -- make sure the basic infrastructure above is taken care of first.  All the above items really constitute the Model for your game.  Your interface is your View and should be kept separate from what the Model is going if at all possible.  You could utilize a Controller to handle the interactions between the two.

9. Place all files in a package named dungeon.

10. EXTRA CREDIT (20 points).  Utilize the Command pattern to allow the undoing the attacks during battle.  Proper application of the pattern would allow you to back up all the way to the beginning of the battle and reissue attacks.

11. All other behaviors for the game are based on the initial set of specifications given for the game.  Those specifications were included as part of the zip file on your previous assignment.

You are welcome to work in pairs for this assignment.  If you do work in pairs, be sure and place both your names at the top of all code.  In addition, when you submit to Canvas include a comment stating who you worked with on the project.  Both team members should submit the solution, this will ensure that it does in fact get submitted.

TO TURN IN

1. A UML Diagram that represents your solution (.pdf format)

2. All source code

3. Captures of output from running your program that demonstrate program correctness.  The output captures do not need to be exhaustive, just provide enough to show the basics of your program are in place.  In addition, if you performed the extra credit, please be sure and demonstrate this functionality.  If your program is console-based, the output capture can be placed in a plain text file.  If you create a GUI interface, then include screen shots in .pdf format.

4. Place the above three items in a zip file named with your last name, followed by first initial of your first name, followed by finalproject349 (e.g. capaultfinalproject349.zip).  If you work in pairs, include both team member names.
NOTE: As this is a new assignment, oversights may have occurred.  Corrections will be made as necessary.  You will be informed of any changes.  It is not the intent of the management to add any more work than was requested above. :-)

FINALLY: I am accepting submissions as late as possible during finals week such that I still have time to make sure they are graded.  With this in mind, no late projects will be allowed.  Canvas will be disabled.