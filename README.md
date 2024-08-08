# Minesweeper Game (MineSweeper)

This project is a simple implementation of a Minesweeper game developed using Java. The game provides a classic Minesweeper experience where users attempt to find mines and are informed of the number of mines surrounding the opened cells.

## Features

- **Game Board:** The game board is created based on the number of rows and columns specified by the user.
- **Mine Placement:** Mines are randomly placed on the board, with a total of one-fourth of the board's cells containing mines.
- **User Input:** Users open cells by entering row and column numbers.
- **Mine Information:** When a cell is opened, the number of surrounding mines is displayed.
- **Game State:** The game ends if the user opens a cell containing a mine. The game is won when all safe cells are revealed.

## Usage

### Starting the Game

- Create an instance of the `MineSweeper` class with the specified number of rows and columns.
- Call the `run()` method to start the game.

### Opening Cells

- Enter row and column numbers in the console to open cells.
- The number of mines around the opened cell is displayed.

### End of Game

- The game ends if a mine is opened, and the user is informed of the mine.
- The game is won when all safe cells are revealed, and the user is congratulated.

