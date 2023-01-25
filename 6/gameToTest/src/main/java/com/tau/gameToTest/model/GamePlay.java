package com.tau.gameToTest.model;

import lombok.Getter;
import com.tau.gameToTest.exceptions.InvalidInputException;
import com.tau.gameToTest.exceptions.EndOfBoardException;
import com.tau.gameToTest.exceptions.ObstacleException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GamePlay {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Getter
    private GameBoard gameBoard;
    private Position finishPosition;
    private boolean endGame = false;

    public GamePlay(){}

    public void startGame(int gameBoardSize) {
        this.gameBoard = new GameBoard(gameBoardSize);
        this.gameBoard.createBoard();
        this.gameBoard.generateGameBoardObjects();
        this.finishPosition = this.gameBoard.getFinishPosition();
    }

    public void move(char direction) {
        int currentRow = this.gameBoard.getPlayerPosition().getRow();
        int currentColumn = this.gameBoard.getPlayerPosition().getColumn();

        switch(Character.toLowerCase(direction)) {
            case 'w' -> {
                if (currentRow - 1 < 0) {
                    throw new EndOfBoardException("You've reached the border of the board.");
                }
                if (this.gameBoard.getFieldCords(currentRow - 1, currentColumn).equals("O")){
                    throw new ObstacleException("You can't move - there is an obstacle.");
                }
                currentRow--;
            }
            case 's' -> {
                if (currentRow + 1 > gameBoard.getGameBoardSize() - 1) {
                    throw new EndOfBoardException("You've reached the border of the board.");
                }
                if (this.gameBoard.getFieldCords(currentRow + 1, currentColumn).equals("O")){
                    throw new ObstacleException("You can't move - there is an obstacle.");
                }
                currentRow++;
            }
            case 'a' -> {
                if (currentColumn - 1 < 0) {
                    throw new EndOfBoardException("You've reached the border of the board.");
                }
                if (this.gameBoard.getFieldCords(currentRow, currentColumn - 1).equals("O")){
                    throw new ObstacleException("You can't move - there is an obstacle.");
                }
                currentColumn--;
            }
            case 'd' -> {
                if (currentColumn + 1 > gameBoard.getGameBoardSize() - 1) {
                    throw new EndOfBoardException("You've reached the border of the board.");
                }
                if (this.gameBoard.getFieldCords(currentRow, currentColumn + 1).equals("O")){
                    throw new ObstacleException("You can't move - there is an obstacle.");
                }
                currentColumn++;
            }
            default -> throw new InvalidInputException("Wrong key. Try again");
        }
        gameBoard.setPlayerPosition(currentRow, currentColumn);

        if (currentRow == this.finishPosition.getRow() && currentColumn == this.finishPosition.getColumn()) {
            System.out.println("You won!");
            endGame = true;
        }
    }

    public void gameFlow(int gameBoardSize) throws IOException{
        startGame(gameBoardSize);
        String readInput;
        char key = 0;
        while(!this.endGame) {
            gameBoard.plotGameBoard();
            readInput = reader.readLine();
            key = readInput.charAt(0);
            if (key == 'q') {
                System.exit(-1);
            }
            try {
                move(key);
            } catch (EndOfBoardException | InvalidInputException | ObstacleException e ) {
                System.out.println(e.getMessage());
            }
        }
    }
}
