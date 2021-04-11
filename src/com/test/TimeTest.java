package com.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest
{

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		Timer mTimer = new Timer();
		mTimer.schedule(new MyClass(), 5000);
	}

}

class MyClass extends TimerTask
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		System.out.println("我延迟了");
	}

}