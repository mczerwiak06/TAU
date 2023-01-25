package com.tau.gameToTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tau.gameToTest.model.GamePlay;
import java.io.IOException;

@SpringBootApplication
public class GameToTestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GameToTestApplication.class, args);
		GamePlay game = new GamePlay();
		System.out.println("Your goal is to reach finish marked as 'F'");
		System.out.println("To move up press 'w'");
		System.out.println("To move down press 's");
		System.out.println("To move left press 'a'");
		System.out.println("To move right press 'd'");
		System.out.println("Obstacles are marked O");
		System.out.println("To quit the game press: q");
		System.out.println();
		game.gameFlow(8);
	}
}
