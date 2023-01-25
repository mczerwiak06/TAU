package com.tau.gameToTest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.Random;
@NoArgsConstructor
public class GameBoard {

    private String[][] gameBoard;
    @Getter
    private int gameBoardSize;

    @Getter
    private Position playerPosition;

    @Getter
    private Position finishPosition;

    public GameBoard(int gameBoardSize){
        this.gameBoardSize = gameBoardSize;
        this.playerPosition = new Position();
        this.finishPosition = new Position();
    }

    public void createBoard() {
        gameBoard = new String[gameBoardSize][gameBoardSize];
        for (int i = 0; i < gameBoardSize; i++){
            Arrays.fill(gameBoard[i], "_");
        }
    }

    private void generateObstacles() {
        Random random = new Random();
        for (int i = 1; i < gameBoardSize; ++i){
            for(int j = 0; j < gameBoardSize; ++j){
                if (random.nextInt(4) == 1){
                    gameBoard[i][j] = "O";
                } else {
                    gameBoard[i][j] = "_";
                }
            }
        }
    }

    private void setFinishPosition (int row, int column) {
        finishPosition.setPosition(row, column);
        gameBoard[row][column] = "F";
    }

    public void setPlayerPosition(int row, int column) {
        gameBoard[playerPosition.getRow()][playerPosition.getColumn()] = "_";
        playerPosition.setPosition(row, column);
        gameBoard[row][column] = "P";
    }

    public void clearFieldsForPlayer() {
        gameBoard[finishPosition.getRow()][finishPosition.getColumn() - 1] = "_";
        gameBoard[playerPosition.getRow()][playerPosition.getColumn() + 1] = "_";
    }

    public void generateGameBoardObjects() {
        Random random = new Random();
        generateObstacles();
        setFinishPosition(random.nextInt(gameBoardSize), gameBoardSize - 1);
        setPlayerPosition(random.nextInt(gameBoardSize), 0);
        clearFieldsForPlayer();
    }
    public String getFieldCords(int row, int column) {
        return gameBoard[row][column];
    }

    public void plotGameBoard() {
        for (String[] i: gameBoard) {
            System.out.println(Arrays.toString(i));
        }
    }
}
