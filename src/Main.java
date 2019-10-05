import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;

import cells.*;
import endgame.EndGameProblem;

public class Main {

	public static void parse() {

		Scanner sc = new Scanner(System.in);

		// Reading Line
		String line = sc.nextLine();
		String[] lineElements = line.split(";");

		// Constructing Map
		String[] elements = lineElements[0].split(",");
		Point tempPoint = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
		Cell[][] map = new Cell[tempPoint.x][tempPoint.y];
		for (int x = 0; x < tempPoint.x; x++)
			for (int y = 0; y < tempPoint.y; y++)
				map[x][y] = new EmptyCell(new Point(x, y));

		// Initiating Iron Man Cell
		elements = lineElements[1].split(",");
		Point ironManLoc = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
		map[ironManLoc.x][ironManLoc.y] = new IronManCell(ironManLoc);

		// Initiating Thanos Cell
		elements = lineElements[2].split(",");
		tempPoint = new Point(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
		map[tempPoint.x][tempPoint.y] = new ThanosCell(tempPoint);

		// Initiating Stones' Cells
		elements = lineElements[3].split(",");
		ArrayList<Point> stonesLoc = new ArrayList<Point>();
		for (int i = 0; i < elements.length; i += 2) {
			tempPoint = new Point(Integer.parseInt(elements[i]), Integer.parseInt(elements[i + 1]));
			stonesLoc.add(tempPoint);
			map[tempPoint.x][tempPoint.y] = new StoneCell(tempPoint);
		}

		// Initiating Warriors' Cells
		elements = lineElements[4].split(",");
		for (int i = 0; i < elements.length; i += 2) {
			tempPoint = new Point(Integer.parseInt(elements[i]), Integer.parseInt(elements[i + 1]));
			map[tempPoint.x][tempPoint.y] = new WarriorCell(tempPoint);
		}

		new EndGameProblem(ironManLoc, stonesLoc, map);

		sc.close();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parse();
	}

}