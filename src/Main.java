import java.util.Scanner;

import cells.*;

import java.awt.Point;
import java.util.ArrayList;

import endgame.*;
import search.*;

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
		Node node = new Node(state);
		Operator operator = null;
		int pathCost = 0;
		PrintEndGame(problem, state);

		while (sc.hasNext()) {
			char c = sc.next().charAt(0);
			switch (c) {
			case 'u':
				operator = problem.getOperators()[0];
				break;
			case 'd':
				operator = problem.getOperators()[1];
				break;
			case 'l':
				operator = problem.getOperators()[2];
				break;
			case 'r':
				operator = problem.getOperators()[3];
				break;
			case 'c':
				operator = problem.getOperators()[4];
				break;
			case 'k':
				operator = problem.getOperators()[5];
				break;
			case 's':
				operator = problem.getOperators()[6];
				break;
			}

			state = (EndGameState) operator.transition(state);
			pathCost = problem.pathCost(node, state, operator);
			node = new Node(state, node, operator, pathCost);

			System.out.println("Enem Arou: " + EndGameUtils.CountEnemiesAround(state));
			System.out.println("Thanos Ar: " + EndGameUtils.IsThanosAround(state));
			System.out.println("Path Cost: " + pathCost);
			PrintEndGame(problem, state);
		}

		sc.close();
	}

}