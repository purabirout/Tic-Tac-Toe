package com.brigdelabz.tictactoe;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToeGame {
	static ArrayList<Integer>playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer>computerPositions = new ArrayList<Integer>();
	public static void main(String args[]) {
		
		char[][]gameBoard =  {{' ','|',' ','|',' '},{'_','+','_','+','_'},{' ','|',' ','|',' '},
				{'_','+','_','+','_'},{' ','|',' ','|',' '}};
				
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement(1-9):");
			int Playerpos = scan.nextInt();
			while(playerPositions.contains(Playerpos) || 
					computerPositions.contains(Playerpos)){
			System.out.println("Position already taken!!"
					+ "Please enter correct position");
			Playerpos = scan.nextInt();
		}
			placePiece(gameBoard,Playerpos,"Player");
			String result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			Random rand = new Random();
			int Computerpos = rand.nextInt(9)+1;
			while(playerPositions.contains(Computerpos) || 
					computerPositions.contains(Computerpos)) {
			Computerpos = rand.nextInt(9)+1;
			}
			placePiece(gameBoard,Computerpos,"Computer");
			
			displayBoard(gameBoard);
			
			result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
		}
		
		
	}
		private static void displayBoard(char[][] gameBoard) {
			for(char[] row: gameBoard) {
				for(char c: row) {
					System.out.print(c);
				}
				System.out.println();
			}
	}

	public static void placePiece(char[][]gameBoard,int position,String user) {
		char symbol = 'X';
		if(user.equals("Player")) {
			symbol = 'X';
			playerPositions.add(position);
		}else if (user.equals("Computer")) {
			symbol = 'O';
			computerPositions.add(position);
			
		}
		
		switch(position) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
			default:
				break;
		}
	}
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List>winnings = new ArrayList<List>();
			winnings.add(topRow);
			winnings.add(midRow);
			winnings.add(botRow);
			winnings.add(leftCol);
			winnings.add(midCol);
			winnings.add(rightCol);
			winnings.add(cross1);
			winnings.add(cross2);
			
			for(List l : winnings) {
				if(playerPositions.containsAll(l)){
					return "Congratulations you won";
				}
				else if(computerPositions.contains(l)){
					return "Computer win!!Sorry";
				}
				else if(playerPositions.size() 
						+ computerPositions.size() == 9){
					return "Board is Full";
				}
			}
			
		return "";		
	}
	
		
	}	
		
	
