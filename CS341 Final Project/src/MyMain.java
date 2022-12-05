public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		// Type D: under control of user
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		user.setVelocity(10);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);

		// Type A: moves UP and DOWN
		Type_A_GameObject upDown = new Type_A_GameObject(100, 100);
		canvas.addKeyListener(upDown);
		upDown.setVelocity(10);
		canvas.addGameObject(upDown);
		
		// Type B: moves UP, DOWN, LEFT and RIGHT/ same as the Type D
		Type_B_GameObject UDLR = new Type_B_GameObject(user);
		canvas.addKeyListener(UDLR);
		UDLR.setVelocity(10);
		canvas.addGameObject(UDLR);
		
		// Type C: moves LEFT and RIGHT
		Type_C_GameObject leftRight = new Type_C_GameObject(300, 300);
		canvas.addKeyListener(leftRight);
		leftRight.setVelocity(10);
		canvas.addGameObject(leftRight);
		
	}

}
