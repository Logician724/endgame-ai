import cells.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

import endgame.*;
import heuristics.*;
import operators.*;
import search.*;
import strategies.*;

public class Main {

	public static String solve(String grid, String strategy, boolean visualize) {
		String route = "";

		EndGameProblem endGameProblem = parse(grid);
		SearchStrategy searchStrategy = null;
		switch (strategy) {
		case "BF":
			searchStrategy = new BFS(endGameProblem);
			break;
		case "DF":
			searchStrategy = new DFS(endGameProblem);
			break;
		case "UC":
			searchStrategy = new UCS(endGameProblem);
			break;
		case "ID":
			searchStrategy = new IDS(endGameProblem);
			break;
		case "GR1":
			searchStrategy = new GRS(endGameProblem, new StonesHeuristic());
			break;
		case "GR2":
			searchStrategy = new GRS(endGameProblem, new StonesThanosHeuristic());
			break;
		case "AS1":
			searchStrategy = new ASS(endGameProblem, new StonesHeuristic());
			break;
		case "AS2":
			searchStrategy = new ASS(endGameProblem, new StonesThanosHeuristic());
			break;
		default:
			throw new IllegalArgumentException("Could not recognize the passed strategy");
		}

		Node node;
		try {
			node = endGameProblem.solveUsingSearch(searchStrategy);
		} catch (SolutionNotFoundException e) {
			return "Error 404: Solution Not Found";
		}

		ArrayList<Node> nodes = new ArrayList<Node>();

		System.out.println(node.getDepth());
		nodes.add(node);
		while (node.getParent() != null) {
			node = node.getParent();
			nodes.add(node);
		}

		while (!nodes.isEmpty()) {
			node = nodes.remove(nodes.size() - 1);
			
			if(node.getOperator() instanceof UpOperator)
				route += "up,";
			if(node.getOperator() instanceof DownOperator)
				route += "down,";
			if(node.getOperator() instanceof LeftOperator)
				route += "left,";
			if(node.getOperator() instanceof RightOperator)
				route += "right,";
			if(node.getOperator() instanceof CollectOperator)
				route += "collect,";
			if(node.getOperator() instanceof KillOperator)
				route += "kill,";
			if(node.getOperator() instanceof SnapOperator)
				route += "snap.";
			

			if (visualize) {
				for (int i = 0; i < (endGameProblem.getMapDimensions().y * 2); i++)
					System.out.print("= ");
				System.out.println();

				System.out.println("Path Cost: " + node.getCost());
				PrintEndGame(endGameProblem, (EndGameState) node.getState());

				for (int i = 0; i < (endGameProblem.getMapDimensions().y * 2); i++)
					System.out.print("= ");
				System.out.println();
				System.out.println();
			}
		}
		
		return route;

	}

	public static EndGameProblem parse(String grid) {
		String[] gridElements = grid.split(";");

		// Constructing Map
		String[] elements = gridElements[0].split(",");
		Point mapDimensions = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Iron Man Cell
		elements = gridElements[1].split(",");
		Point ironManLoc = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Thanos Cell
		elements = gridElements[2].split(",");
		Point thanosLoc = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));

		// Initiating Stones' Cells
		elements = gridElements[3].split(",");
		HashSet<Point> stonesLoc = new HashSet<Point>();
		for (int i = 0; i < elements.length; i += 2)
			stonesLoc.add(new Point(Integer.parseInt(elements[i]), Integer.parseInt(elements[i + 1])));

		// Initiating Warriors' Cells
		elements = gridElements[4].split(",");
		HashSet<Point> warriorsLoc = new HashSet<Point>();
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

		String grid = "5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3";
		String strategy = "ID";
		boolean visualize = false;
		long startTime = System.nanoTime();

		System.out.println(solve(grid, strategy, visualize));

		long endTime = System.nanoTime();
		long timeElapsed = (endTime - startTime) / 1000000;
		System.out.println("Time: " + timeElapsed + "ms");

	}

}