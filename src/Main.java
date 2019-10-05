import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;

import endgame.EndGameProblem;

public class Main {

	public static void parse() {
		Scanner sc = new Scanner(System.in);

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

		new EndGameProblem(ironManLoc, thanosLoc, stonesLoc, warriorsLoc, mapDimensions);

		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parse();
	}

}