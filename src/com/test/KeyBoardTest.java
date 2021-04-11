package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyBoardTest
{

	public static void main(String[] args) throws AWTException
	{
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}

}
