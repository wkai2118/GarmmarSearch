package com.wkai;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import com.gui.FloatingWindow;

public class GarmmarSearchMain implements NativeMouseInputListener
{
	public static FloatingWindow test = new FloatingWindow();
	static GarmmarSearchMain demo;
	static boolean DblclickFlag = false;
	static boolean TimeFlag = true; // ��ʱ�����أ�Ϊ�˷�ֹ�ڶ��ε�����´�����ʱ��

	int PressX;
	int PressY;

	public static int ReleaseX;
	public static int ReleaseY;

	public static Timer mTimer = new Timer();

	public static void main(String[] args)
	{
		try
		{
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		demo = new GarmmarSearchMain();
		GlobalScreen.addNativeMouseListener(demo);
		GlobalScreen.addNativeMouseMotionListener(demo);

		// �ر���־
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		logger.setUseParentHandlers(false);
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent e)
	{
		// ���˫��
		if (TimeFlag)
		{
			mTimer.schedule(new ClickTimeDelay(), 200);
			TimeFlag = false;
		}
		if (DblclickFlag)
		{
//			System.out.println("��˫����");
			test.setBounds(e.getX() + 10, e.getY() - 50, 38, 38);
			test.setVisible(true);
//			mTimer.schedule(new CloseDelay(), 1500);
		}
		DblclickFlag = true;
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e)
	{
//		System.out.println("x:" + e.getX() + "y:" + e.getY());
		PressX = e.getX();
		PressY = e.getY();
		if (notInRectangle(PressX, PressY))
		{
			test.setVisible(false);
		}
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e)
	{
		ReleaseX = e.getX();
		ReleaseY = e.getY();
		if ((ReleaseX != PressX || ReleaseY != e.getY()))
		{
//			System.out.println("���϶���");
			test.setBounds(e.getX() + 10, e.getY() - 50, 38, 38);
			test.setVisible(true);
//			mTimer.schedule(new CloseDelay(), 1500);
		}
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent e)
	{
		// ����϶�
//		System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent e)
	{
		// ����ƶ�

	}

	public boolean notInRectangle(int x, int y)
	{
		if ((x >= ReleaseX + 10 && y <= ReleaseX + 48) && (y >= ReleaseY - 50 && y <= ReleaseY - 12))
		{
			return false;
		}
		return true;
	}

}

class ClickTimeDelay extends TimerTask
{
	@Override
	public void run()
	{
		GarmmarSearchMain.DblclickFlag = false;
		GarmmarSearchMain.TimeFlag = true;
	}
}

class CloseDelay extends TimerTask
{
	@Override
	public void run()
	{
		GarmmarSearchMain.test.setVisible(false);
		System.out.println("������ʧ��");
	}
}