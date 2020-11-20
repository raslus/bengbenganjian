package beng;

import java.awt.AWTException;
import java.awt.Robot;

public class Main {
	public static void main(String[] args) throws AWTException {
		MPanel mPanel = new MPanel();
		mPanel.run();
//		Robot robot = new Robot();
//			robot.keyPress(65);
//		System.out.println(KeyEnum.A);
	}
}