package test;

import game.Robot;
import game.SquareTable;

import java.util.Scanner;

public class Tester {

	/**
	 * main access of the game
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the size of the table! The number must bigger than 1:");
		String size;

		while (true) {
			size = input.nextLine();

			if (size != null && Integer.parseInt(size) > 1) {
				break;
			}
			System.out.println("The number must bigger than 1!!!!");
		}
		Robot robot = new Robot();
		SquareTable table = new SquareTable(robot);

		table.setSize(Integer.parseInt(size));

		String[] commands;
		int count = 1;

		while (true) {
			displayMenu(count);

			commands = splitCommands(input.nextLine(), " ");

			if (commands != null) {
				if ("QUIT".equals(commands[0])) {
					break;
				}
				if (count == 1 && !"PLACE".equals(commands[0])) {
					System.out.println("You must place the robot first!");
					continue;
				}
				if ("PLACE".equals(commands[0]) && !validatePlaceInput(commands, table.getSize())) {
					continue;
				}

				readCommands(table, commands);
				count++;
			} else {
				System.out.println("Please enter a valid command!");
			}
		}

	}

	/**
	 * display the options menu
	 * 
	 * @param count the numbers of menu display
	 */
	private static void displayMenu(int count) {
		System.out.println("===============================================");
		System.out.println("Please enter one of the following commands:");
		System.out.println("1- PLACE X,Y,NORTH/EAST/SOUTH/WEST | e.g. PLACE 0,0,NORTH");

		if (count >= 2) {
			System.out.println("2- MOVE;");
			System.out.println("3- LEFT/RIGHT;");
			System.out.println("4- REPORT;");
			System.out.println("5- QUIT;");
		}
		System.out.println("===============================================");
	}

	/**
	 * split the commands from user in required format
	 * 
	 * @param command    the commands from users.
	 * @param splitRegex the required format
	 * @return String[] the sliced commands
	 */
	private static String[] splitCommands(String command, String splitRegex) {
		String[] commands = command.toUpperCase().split(splitRegex);
		return commands;
	}

	/**
	 * validate the user inputs
	 * 
	 * @param commands  the input commands
	 * @param tableSize the size of game table
	 * @return true if user inputs are valid; false if they are invalid
	 */
	private static boolean validatePlaceInput(String[] commands, int tableSize) {
		// if input meet "place X,Y,DIRECTION" format
		if (commands.length == 2) {
			String[] robotPosition = splitCommands(commands[1], ",");

			if (robotPosition.length == 3) {
				if (Integer.parseInt(robotPosition[0]) >= 0 && Integer.parseInt(robotPosition[0]) < tableSize) {
					if (Integer.parseInt(robotPosition[1]) >= 0 && Integer.parseInt(robotPosition[1]) < tableSize) {
						switch (robotPosition[2]) {
							case "NORTH":
							case "EAST":
							case "SOUTH":
							case "WEST":
								return true;
						}
					}
				}
			}
		}
		System.out.println("Please enter a valid command!!!");
		return false;
	}

	/**
	 * read the user's input commands
	 * 
	 * @param table    the game table
	 * @param commands the input commands
	 */
	private static void readCommands(SquareTable table, String[] commands) {
		String[] placePosition;

		switch (commands[0]) {
			case "MOVE":
				table.move();
				break;
			case "LEFT":
				table.changeDirection(commands[0]);
				break;
			case "RIGHT":
				table.changeDirection(commands[0]);
				break;
			case "REPORT":
				table.report();
				break;
			case "PLACE":
				placePosition = splitCommands(commands[1], ",");

				table.place(Integer.parseInt(placePosition[0]), Integer.parseInt(placePosition[1]), placePosition[2]);
				break;
			default:
				System.out.println("Please enter the command in a correct format!!");
		}
	}

}