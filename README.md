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
- Added new background image in-game to fit the theme of the game. Changed platform image, ball image and gold ball image.

g. Sound Effect and Background track.
- Initialized a new class, Sound.java. Here is a list of all sounds added and where:

Background tracks-
a. Main menu song. Added to main menu.
b. In-game song. Added to in-game.
c. Game over song. Added to losing screen.

Sound effects-
a. Brick broken sfx. When a block breaks.
b. Losing a heart sfx. When ball touches the ground.
c. Platform sfx. When ball touches platform.
d. Power-up sfx. When ball breaks a choco or goldstar block.
e. Heart power-up sfx. When ball breaks a heart block.
f. Level up sfx. When player moves on to the next level.
g. Select button. When pressing buttons in main menu and in-game.


h. Save / Load feature.
Pressing 's' in game saves a state of the game in the directory "". 
Player can choose to load existing save file when starting the game.
Fixed an issue where the game would regenerate broken blocks when loading an existing save file.

i. Losing Screen.
When player loses all hearts, a button to try again will appear. This button takes the player back to the starting screen of the game.

3. Implemented but not working properly-------------------------------------------

List of features that sometimes does not work as intended. No game breaking features however.

a. Block collision. Sometimes the block collision is a little iffy, but there is NO instance where the ball will phase through the blocks.
b. Wall collision. Works but not as intended. Want it to collide at the radius of the ball (which happens sometimes), but sometimes it does not.
c.Win screen. The game won't show the win screen. Instead it will automatically initialize the starting screen of the game, back to level 1.

4. Features not implemented-------------------------------------------------------

a. A new power-up.
-Initially a pierce ball power-up was supposed to be implemented. The idea was that the power-up will implement similiarly like the gold ball (changes the ball for a limited time).The collisions of the ball logic will also be swapped, so that when bouncing away from the block, it would bounce into the block. 

-An implementation was tried, but was not successful. The game would crash once the ball collides with a block. The issue was never resolved, so as a result it was taken out of the game.

b. A pause button.
- A pause button 'p' was to be added in-game, that would stop the game engine with stop.engine, and upon pressing the button 'p' again would initialize start.engine, resuming the game state. There was also a plan to add another background music during the paused state, and buttons to exit the game back to the main menu.
- However, there was an error with the sound implementation, where the in-game sound would stop as inteneded, but won't resume when the game engine starts again. As such, the implementation of a pause button was scrapped and the functionality to exit the game was moved to the 'esc' button instead.

c. A winning screen.
- This is in accordance to the win-screen error previously mentioned in the 'implemented but not working properly' section. Initially, the fix was to cover-up the game win screen with another screen, which would be the win screen. It would contain a button that will lead the player back to either the starting screen of the game or the main menu.
 -The implementation was semi-successful. What would happen was the win screen would appear in a seperate window to the game, and this would cause multiple states of the game to run in different windows.
  - The obvious fix was to make it appear in the same window. But I couldn't get it to work, and at times it would crash the game. So I decided to not include it in.

d. LoadSave feature in main menu.
-Initially, the main menu had 3 buttons 'Start game', 'Loadsave' and 'Exit'. The start game would initialize a new game. The loadsave was intended to allow players to load a saved state from the main menu itself, but connecting the button to the loadgame method in the main class would cause some errors to occur and the main menu to crash or cause the other buttons to not work.
-The solution was to remove this button entirely, and add the function of loadsave into the starting screen of the game instead (right below the start new game button). The main menu buttons would also be renamed to 'Enter game' and 'Exit'.

5. New java classes---------------------------------------------------------------

a. BrickBreakerMainMenu.java class:

-Brief Description-

Starting screen of the game. Main menu class is where the player would run the game. Contains a button to initilize the start method in main called "Enter game" and an exit button.

-Location of code-

In another class called BrickBreakerMainMenu.java. Some of the class method can be found in main, specifically the 'esc' button switch case, initializing the main menu screen on press.

b. Sound.java class:

-Brief Description-

A class to initialize and manage all the sound files in the game.

-Location of code-

In another class called Sound.java. The class methods can be seen being called mostly in Main.java, but there are some instances in BrickBreakerMainMenu.java and Score.java.

6. Modified java classes----------------------------------------------------------

a. GameEngine.java:
-Massive changes in this class. The main reason is the use of threads. The use of Thread.sleep causes issues when dealing with UI updates and transitions between levels. Its why in some instances, the level increment will increase infinitely.

-The use of animation timer in place of threads is better for hanlding game loops.

b. Main.java
