package com.tau.gameToTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GameToTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameToTestApplication.class, args);
		printBoard();
	}
	public static void printBoard() {

		String[][] board = new String[6][6];
		int playerPositionX = 1;
		int playerPositionY = 5;
		String message = "";
		boolean playGame = true;
		//drawing board
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board[i][j] = "      ";
			}
		}
		for (int i = 0; i < 5; i++){
			for (int j = 1; j < 4; j++){
				board[i][j] = "      ";
			}
		}

		//drawing obstacles
		int min = 0;
		int max = 5;
			for (int i = 0; i < 10; i++) {
				int randomHorizontal = (int) Math.floor(Math.random() * (max - min + 1) + min);
				int randomVertical = (int) Math.floor(Math.random() * (max - min + 1) + min);
				if (randomVertical == 0 && randomHorizontal == 4){
					randomHorizontal += 1;
					randomVertical += 1;
				}
				if (randomVertical == 5 && randomHorizontal == 1) {
					randomHorizontal += 1;
					randomVertical -= 1;
				}
				board[randomVertical][randomHorizontal] = " XXXX ";
			}

		while(playGame) {

			board[5][1] = "START ";
			board[0][4] = "FINISH";
			board[playerPositionY][playerPositionX] = "PLAYER";

			System.out.println("───────────────────────────────────────────");
			System.out.println("│" + board[0][0] + "│" + board[0][1] + "│" + board[0][2] + "│" + board[0][3] + "│" + board[0][4] + "│" + board[0][5] + "│");
			System.out.println("-------------------------------------------");
			System.out.println("│" + board[1][0] + "│" + board[1][1] + "│" + board[1][2] + "│" + board[1][3] + "│" + board[1][4] + "│" + board[1][5] + "│");
			System.out.println("-------------------------------------------");
			System.out.println("│" + board[2][0] + "│" + board[2][1] + "│" + board[2][2] + "│" + board[2][3] + "│" + board[2][4] + "│" + board[2][5] + "│");
			System.out.println("-------------------------------------------");
			System.out.println("│" + board[3][0] + "│" + board[3][1] + "│" + board[3][2] + "│" + board[3][3] + "│" + board[3][4] + "│" + board[3][5] + "│");
			System.out.println("-------------------------------------------");
			System.out.println("│" + board[4][0] + "│" + board[4][1] + "│" + board[4][2] + "│" + board[4][3] + "│" + board[4][4] + "│" + board[4][5] + "│");
			System.out.println("-------------------------------------------");
			System.out.println("│" + board[5][0] + "│" + board[5][1] + "│" + board[5][2] + "│" + board[5][3] + "│" + board[5][4] + "│" + board[5][5] + "│");
			System.out.println("───────────────────────────────────────────");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter move: ");

			char move = scanner.next().charAt(0);
			switch(move) {
				case 'w':
					if(playerPositionY > 0 ) {
						if (playerPositionY == 1 && board[0][playerPositionX] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionY > 1 && board[playerPositionY-1][playerPositionX] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionY-1 == 0 && playerPositionX == 4) {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionY -=1 ;
							message = "Congrats, you won!!!";
						} else {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionY -= 1;
							message = "";
						}
					} else {
						message = "You can't go up. You've reached the border";
					}
					System.out.println(message);
					break;
				case 's':
					if(playerPositionY < 5 ) {
						if (playerPositionY == 4 && board[5][playerPositionX] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionY < 4 && board[playerPositionY+1][playerPositionX] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionY += 1;
							message = "";
						}
					} else {
						message = "You can't go up. You've reached the border";
					}
					System.out.println(message);
					break;
				case 'a':
					if(playerPositionX > 0 ) {
						if (playerPositionX == 1 && board[playerPositionY][0] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionX > 1 && board[playerPositionY][playerPositionX-1] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionY == 0 && playerPositionX == 5) {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionX -=1 ;
							message = "Congrats, you won!!!";
						} else {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionX -= 1;
							message = "";
						}
					} else {
						message = "You can't go left. You've reached the border";
					}
					System.out.println(message);
					break;
				case 'd':
					if(playerPositionX < 5 ) {
						if (playerPositionX == 4 && board[playerPositionY][5] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						} else if(playerPositionX < 4 && board[playerPositionY][playerPositionX+1] == " XXXX "){
							message = "You've hit an obstacle. You loose";
						}  else if(playerPositionY == 0 && playerPositionX == 3) {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionX +=1 ;
							message = "Congrats, you won!!!";
						} else {
							board[playerPositionY][playerPositionX] = "      ";
							playerPositionX += 1;
							message = "";
						}
					} else {
						message = "You can't go right. You've reached the border";
					}
					System.out.println(message);
					break;
				case 'q': {
					System.out.println("The game has ended");
					playGame = false;
				}
			}
		}
	}
}
