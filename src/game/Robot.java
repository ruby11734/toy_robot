package game;

public class Robot {

	private String faceDirection;
	private int positionY;
	private int positionX;

	// constructor
	public Robot() {
	}

	public Robot(int positionX, int positionY, String faceDirection) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.faceDirection = faceDirection;
	}

	/**
	 * get the current facing direction of Robot
	 * 
	 * @return the facing direction of Robot
	 */
	public String getFaceDirection() {
		return faceDirection;
	}

	/**
	 * set the facing direction of robot
	 * 
	 * @param faceDirection set the facing direction
	 */
	public void setFaceDirection(String faceDirection) {
		this.faceDirection = faceDirection;
	}

	/**
	 * get the position Y of robot
	 * 
	 * @return position Y
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * set the position Y of robot
	 * 
	 * @param positionY the current position Y
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * @return position X
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * set the position X of the robot
	 * 
	 * @param positionX the current position X
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * move 1 step further towards current direction
	 * 
	 * @param size the size of the game table
	 * @return true if move one step if successful; false if the robot is at the
	 *         edge of the table
	 */

	public boolean move(int size) {
		switch (faceDirection) {
			case "NORTH":
				if (positionY + 1 < size) {
					positionY += 1;
					return true;
				}
			case "EAST":
				if (positionX + 1 < size) {
					positionX += 1;
					return true;
				}
			case "SOUTH":
				if (positionY - 1 >= 0) {
					positionY -= 1;
					return true;
				}
			case "WEST":
				if (positionX - 1 >= 0) {
					positionX -= 1;
					return true;
				}
			default:
				System.out.println("You are already at the edge of the table!!!");
				return false;

		}
	}

	/**
	 * change the facing direction to required direction
	 * 
	 * @param direction LEFT/ RIGHT of current facing direction
	 */
	public void changeDirection(String direction) {
		if ("LEFT".equals(direction)) {
			switch (faceDirection) {
				case "NORTH":
					faceDirection = "WEST";
					break;
				case "EAST":
					faceDirection = "NORTH";
					break;
				case "SOUTH":
					faceDirection = "EAST";
					break;
				case "WEST":
					faceDirection = "SOUTH";
					break;
			}
		} else {
			switch (faceDirection) {
				case "NORTH":
					faceDirection = "EAST";
					break;
				case "EAST":
					faceDirection = "SOUTH";
					break;
				case "SOUTH":
					faceDirection = "WEST";
					break;
				case "WEST":
					faceDirection = "NORTH";
					break;
			}
		}
	}

}