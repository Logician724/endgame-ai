import java.util.Scanner;

import cells.*;

import java.awt.Point;
import java.util.ArrayList;

import endgame.EndGameProblem;
import endgame.EndGameState;

public class Main {

	public static EndGameProblem parse() {
		Scanner sc = new Scanner(System.in);

		// Reading Line
		String line = sc.nextLine();
		sc.close();
		
		String[] lineElements = line.split(";");

		// Constructing Map
		String[] elements = lineElements[0].split(",");
		Point mapDimensions = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Iron Man Cell
		elements = lineElements[1].split(",");
		Point ironManLoc = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Thanos Cell
		elements = lineElements[2].split(",");
		Point thanosLoc = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Stones' Cells
		elements = lineElements[3].split(",");
		ArrayList<Point> stonesLoc = new ArrayList<Point>();
		for (int i = 0; i < elements.length; i += 2)
			stonesLoc.add(new Point(Integer.parseInt(elements[i]), Integer.parseInt(elements[i + 1])));

		// Initiating Warriors' Cells
		elements = lineElements[4].split(",");
		ArrayList<Point> warriorsLoc = new ArrayList<Point>();
		for (int i = 0; i < elements.length; i += 2)
			warriorsLoc.add(new Point(Integer.parseInt(elements[i]), Integer.parseInt(elements[i + 1])));

		
		
		return new EndGameProblem(ironManLoc, thanosLoc, stonesLoc, warriorsLoc, mapDimensions);
	}
	
	public static void PrintEndGame(EndGameProblem game) {
		Cell[][] map = game.constructMap(((EndGameState) game.getInitialState()));
		
		for(int i = 0; i < (map.length * 2); i++)
			System.out.print("- ");
		System.out.println();
		
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				if(map[x][y] instanceof EmptyCell)
					System.out.print(" " + " | ");
				if(map[x][y] instanceof IronManCell)
					System.out.print("I" + " | ");
				if(map[x][y] instanceof StoneCell)
					System.out.print("S" + " | ");
				if(map[x][y] instanceof ThanosCell)
					System.out.print("T" + " | ");
				if(map[x][y] instanceof WarriorCell)
					System.out.print("W" + " | ");
			}
			System.out.println();
			
			for(int i = 0; i < (map.length * 2); i++)
				System.out.print("- ");
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		EndGameProblem game = parse();
		PrintEndGame(game);
	}

}