# COMP2042_CW_hcyjj2

1. Compilation instruction--------------------------------------------------------

To compile and run the game, download the entire codebase from github. Save it under a folder, any name. Open the folder in IntelliJ under existing project. Once you have opened the folder, import the java library. Then, all errors will cease. Run the game from the main menu class.

2. Implemented and working properly-----------------------------------------------

List of features that are working properly:

a. Main Menu.
-Main menu contains an 'Enter game' button which initialises the start method in main, launching the game and an 'Exit' button, which closes the program.
-Main menu will launch the game in the same window, and not in another window.

b. Refactored Game Engine.
-Game runs more smoothly with the use of animation timer instead of threads, as threads is causing a lot of errors. Game now increments levels properly and wont crash unexpectedly.

c. Heart System.
-Player starts with 3 heart initially. Touching the bottom screen decreases heart count by 1. Lose all hearts will lose the game.
-Fixed an issure where heart count will decrease rapidly and near infinitely once they lose a second heart.

d. Power-up System.
- 3 power-up blocks exists in the game, and will randomly appear in each level.
  
Heart block:
Increases heart count by +1.
  
Choco block:
Drops an item. When claimed by the platform, increases score count by +3.
  
Goldstar block:
Turns ball into gold ball. When in gold ball mode, prevents heart from decrementing when hitting the bottom of the stage.

e. Button to Exit Game to Main Menu.
- Pressing 'esc' while in-game brings back player to the main menu.

f. Background Images and Assest Changes.
- 

f. Sound Effect and Background track.
- Initialized a new class, Sound.java. Added background sound and 
