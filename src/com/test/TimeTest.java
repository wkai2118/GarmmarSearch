package com.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest
{

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		Timer mTimer = new Timer();
		mTimer.schedule(new MyClass(), 5000);
	}

}

class MyClass extends TimerTask
{

	@Override
	public void run()
	{
		// TODO �Զ����ɵķ������
		System.out.println("���ӳ���");
	}

}