import java.util.Scanner;

import cells.*;

import java.awt.Point;
import java.util.ArrayList;

import endgame.EndGameProblem;
import endgame.EndGameState;
import operators.*;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static EndGameProblem parse() {

		// Reading Line
		String line = sc.nextLine();

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

	public static void PrintEndGame(EndGameProblem problem, EndGameState state) {
		Cell[][] map = problem.constructMap(state);

		for (int i = 0; i < (map.length * 2); i++)
			System.out.print("- ");
		System.out.println();

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				char c = ' ';
				if (map[x][y] instanceof IronManCell)
					c = 'I';
				if (map[x][y] instanceof IronManStoneCell)
					c = 'X';
				if (map[x][y] instanceof IronManThanosCell)
					c = 'Z';
				if (map[x][y] instanceof StoneCell)
					c = 'S';
				if (map[x][y] instanceof ThanosCell)
					c = 'T';
				if (map[x][y] instanceof WarriorCell)
					c = 'W';
				System.out.print(c + " | ");
			}
			System.out.println();

			for (int i = 0; i < (map.length * 2); i++)
				System.out.print("- ");

			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		EndGameProblem problem = parse();
		EndGameState state = ((EndGameState) problem.getInitialState());
		PrintEndGame(problem, state);

		while (sc.hasNext()) {
			char c = sc.next().charAt(0);
			switch (c) {
			case 'u':
				problem.getOperators()[0].transition(state);
				state = new UpOperator(problem.getMapDimensions());
				break;
			case 'd':
				state = new DownOperator(problem.getMapDimensions()).transition(state);
				break;
			case 'l':
				state = new LeftOperator(problem.getMapDimensions()).transition(state);
				break;
			case 'r':
				state = new RightOperator(problem.getMapDimensions()).transition(state);
				break;
			case 'c':
				state = new CollectOperator().transition(state);
				break;
			case 'k':
				state = new KillOperator(problem.getMapDimensions()).transition(state);
				break;
			case 's':
				state = new SnapOperator().transition(state);
				break;
			}
			PrintEndGame(problem, state);
		}

		sc.close();
	}

}