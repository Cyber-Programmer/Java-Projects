### Description

This Java program is a simplified version of the classic Pac-Man game, where the player navigates a Pac-Man character through a maze to collect food while avoiding enemies. The game includes several components:

1. **Pacman Class**:
   - Handles the movement of Pac-Man based on player input.
   - Updates the game state, including Pac-Man's position, collected food, and the player's score.
   - Prevents movement through walls and ensures valid moves.

2. **Enemies Class**:
   - Represents the enemies in the game.
   - Enemies move randomly within the maze.
   - Avoids walls but can traverse through food without collecting it.

3. **MazeMaker Class**:
   - Generates and sets up the maze with walls, food, and open spaces.
   - Keeps track of the total amount of food in the maze.
   - Provides a method to display the current state of the maze.

4. **GameBoard Class**:
   - The main class that initializes and starts the game.
   - Creates instances of the maze, Pac-Man, and enemies.
   - Runs the game loop, updating and redrawing the maze after each move.
   - Checks for win and loss conditions: the player wins by collecting all food and loses if Pac-Man collides with an enemy.

### Game Rules

1. **Movement**:
   - The player can move Pac-Man right, left, down, or up using specific inputs.
   - Moves are validated to prevent crossing into walls.

2. **Scoring**:
   - Each collected food item increases the score by 5 points.
   - The game keeps track of the remaining food.

3. **Win Condition**:
   - The player wins when all food items are collected.

4. **Loss Condition**:
   - The player loses if Pac-Man collides with any enemy.

### Maze Layout

- The maze is a 20x20 grid with predefined walls (`#`) and food (`.`) locations.
- Special sections of the maze are designed to create paths and barriers for more challenging navigation.

### Game Interaction

- The game prompts the player for movement inputs.
- After each move, the game updates the maze and checks for collision and game end conditions.
- The maze is redrawn after every move, displaying the current positions of Pac-Man and the enemies, and the player's score.

### Objectives

- Navigate Pac-Man through the maze to collect all food items.
- Avoid collisions with the randomly moving enemies to stay in the game.
- Achieve the highest possible score by collecting all food and avoiding enemies.
