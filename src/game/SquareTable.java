package game;

public class SquareTable {

	private int size;
	private int[][] table;
	private Robot robot;

	public SquareTable(Robot robot) {
		this.robot = robot;

	}

	/**
	 * get the size of the game table
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * set the size of the game table
	 * 
	 * @param size size of table
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * display the table with robot on it
	 * 
	 * @param x             the position x of the robot
	 * @param y             the position y of the robot
	 * @param faceDirection the facing direction of the robot
	 */
	private void displayTable(int x, int y, String faceDirection) {
		System.out.println("===============================================");
		for (int i = table.length - 1; i >= 0; i--) {
			for (int j = 0; j < table[i].length; j++) {

				// "=" represent the robot
				if (i == y & j == x) {
					System.out.print("= ");
					continue;
				}
				// fill the table with "*"
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("You are @ " + x + ", " + y + ", facing towards " + faceDirection);
		System.out.println("===============================================");
		System.out.println();
	}

	/**
	 * initiate the table and place the robot on a required place
	 * 
	 * @param positionX the position X of the robot
	 * @param positionY the position Y of the robot
	 * @param direction the facing direction of the robot
	 */
	public void place(int positionX, int positionY, String direction) {
		robot.setPositionX(positionX);
		robot.setPositionY(positionY);
		robot.setFaceDirection(direction);

		table = new int[size][size];
		displayTable(positionX, positionY, direction);
	}

	/**
	 * move the robot one step forward if it is not at the edge of the table
	 */
	public void move() {
		if (robot.move(size)) {
			displayTable(robot.getPositionX(), robot.getPositionY(), robot.getFaceDirection());
		}
	}

	/**
	 * change the facing direction of the robot
	 * 
	 * @param command change to "LEFT/RIGHT" of current facing direction
	 */
	public void changeDirection(String command) {
		robot.changeDirection(command);

		displayTable(robot.getPositionX(), robot.getPositionY(), robot.getFaceDirection());
	}

	/**
	 * export the current status of the robot
	 */
	public void report() {
		System.out.print(robot.getPositionX() + "," + robot.getPositionY() + "," + robot.getFaceDirection());

		System.out.println();
	}

}
