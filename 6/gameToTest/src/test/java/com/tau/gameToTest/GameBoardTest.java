package com.tau.gameToTest;

import com.tau.gameToTest.model.GameBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.List;

public class GameBoardTest {

   private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard(8);
        gameBoard.createBoard();
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    public void shouldCreateGameBoard() {
        //given

        //when

        //then
        assertEquals("_", gameBoard.getFieldCords(4,6));
    }

    @Test
    public void shouldCreateObjects() {
        //given

        //when
        gameBoard.generateGameBoardObjects();
        //then
        assertTrue(List.of("O", "F", "P", "_").contains(gameBoard.getFieldCords(4,6)));
    }

    @Test
    public void shouldSetFinishPosition() {
        //given

        //when
        gameBoard.generateGameBoardObjects();
        //then
        assertEquals("F", gameBoard.getFieldCords(gameBoard.getFinishPosition().getRow(),gameBoard.getFinishPosition().getColumn()));
    }

    @Test
    public void shouldSetPlayerPosition() {
        //given

        //when
        gameBoard.generateGameBoardObjects();
        //then
        assertEquals("P", gameBoard.getFieldCords(gameBoard.getPlayerPosition().getRow(), gameBoard.getPlayerPosition().getColumn()));
    }
}
