# COMP2042_CW_hcyjj2

1. Compilation instruction--------------------------------------------------------

To compile and run the game, download the entire codebase from github. Save it under a folder, any name. Open the folder in IntelliJ under existing project. Once you have opened the folder, import the java library into the project structure. Then, all errors will cease. Run the game from the BrickBreakerMainMenu class.

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
- Fixed an issue with the infinite lives loss on the second life lost. There was no resetcollideflag() when checking for bottom wall collision. This led to the bottom wall collision to not initiate during the next collision boundary, but the lives will still be lost once the ball crosses that 'invisible' boundary.

-Added a new method called initializeLevel method. The use of this method is to initialize the game assests. This method would be called in multiple instances, such as in loadgame, savegame and start.

-Fixed the issue of save and load game, where the blocks count would regenerate eventhough they are destroyed.

-Added music into the main class.

-Added 3 new method checkLeftCollision, checkRightCollision and checkTopCollision to for better wall collision handling. The collisions include the ballRadius as well so that the ball can bounce off the wall from its radius instead of the center.

c. Score.java

-Fixed the show and showMessage to not use threads. This fixed the error of the game crashing when two or more blocks are destroyed at once or in a very time interval.

-Added a soundtrack for when player loses.

d. Block.java

-Updated the checkCollisionWithBlock method to include ballRadius, so that the ball will bounce of the block at the radius of the ball instead of its center (sometimes happens, sometimes doesn't).

7. Unexpected Problems------------------------------------------------------------

1. Infinitely losing lives upon second life lost.
- This took me so long to fix. And it was unexpected as well because it only happened after I changed some of the code in main and other areas. It took me a while but i managed to fix it after adding resetCollideFlag() to the bottom wall collision checker.

2. Multi-windows appearing during the game.
-The implementation of the main menu class caused some error to the game. Initially, when the main menu would call the start() method from Main.java, the game would initialize in a new window. This caused some multi-window issues to occur. For example, sometimes, when loading from a saved state, the game will play as intended but then a new window would appear, running the next level while the previous window runs the current level.

-Managed to fix the initial issue of the main menu, which was the main menu opening a new window when initializing the start() method. By fixing this issue (making it so that it initializes on the same window), the issue of multi window never appeared again.

3. Implementation of sound effects in game.
-The first attempt at sound implementation was to add a brick breaking sound effet. When this happened, an error would occur that would crash the game once a brick was broken. The idea was scrapped for the time being and later revisited.
-The multi-window also caused some complications. Specifically, the main menu would play a main menu track. Once the enter game button is pressed, the game would be initialised in another window, where it would play the in-game audio. Since the main menu is still opened in a previous window, the sound would overlap. Fixing the multi-window error fixed this complication as well.

3. Implementation of sound effects.
-The very first attempt to implement sound into the game was a sound effect for the brick breaking. However, it was not successful as the game would crash once a brick was broken. The idea of implementing sound was scrapped for a while before being revisited again.
-The multi-window issue I mentioned above also caused some complications in the implementation of the sound. Specifically, when the main menu background music would play, and the game is initialised, the game would start alongside the in-game music, but the 
