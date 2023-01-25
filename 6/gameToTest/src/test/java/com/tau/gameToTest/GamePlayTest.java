package com.tau.gameToTest;

import com.tau.gameToTest.exceptions.EndOfBoardException;
import com.tau.gameToTest.exceptions.ObstacleException;
import com.tau.gameToTest.model.GamePlay;
import com.tau.gameToTest.model.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {

    private GamePlay gamePlay;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        gamePlay = new GamePlay();
        gamePlay.startGame(8);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldThrowEndOfBoarExceptionWhenMowingUpToBorder() {
        //given
        this.gamePlay.getGameBoard().setPlayerPosition(0, 0);
        //when

        //then
        assertThrows(EndOfBoardException.class, () -> gamePlay.move('w'));
    }

    @Test
    public void shouldThrowEndOfBoarExceptionWhenMowingDownToBorder() {
        //given
        this.gamePlay.getGameBoard().setPlayerPosition(7, 0);
        //when

        //then
        assertThrows(EndOfBoardException.class, () -> gamePlay.move('s'));
    }

    @Test
    public void shouldThrowEndOfBoarExceptionWhenMowingLeftToBorder() {
        //given

        //when

        //then
        assertThrows(EndOfBoardException.class, () -> gamePlay.move('a'));
    }

    @Test
    public void shouldThrowEndOfBoarExceptionWhenMowingRightToBorder() {
        //given
        this.gamePlay.getGameBoard().setPlayerPosition(0, 7);
        //when

        //then
        assertThrows(EndOfBoardException.class, () -> gamePlay.move('d'));
    }

    @Test
    public void shouldGetWinningMessage() {
        //given
        System.setOut(new PrintStream(outStream));
        this.gamePlay.getGameBoard().setPlayerPosition(gamePlay.getGameBoard().getFinishPosition().getRow(),
                gamePlay.getGameBoard().getFinishPosition().getColumn() - 1);
        //when
        gamePlay.move('d');
        //then
        assertEquals("You won!", outStream.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    public void shouldThrowObstacleExceptionWhenHitingObstacle() {
        //given
        Position obstaclePosition = new Position();
        //when
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if(gamePlay.getGameBoard().getFieldCords(i, j).equals("O")) {
                    obstaclePosition.setPosition(i,j);
                    break;
                }
            }
        }
        gamePlay.getGameBoard().setPlayerPosition(obstaclePosition.getRow(), obstaclePosition.getColumn() - 1);
        //then
        assertThrows(ObstacleException.class, () -> gamePlay.move('d'));
    }
}
