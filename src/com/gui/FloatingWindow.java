package com.gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import com.wkai.Clipboard;
import com.wkai.GarmmarSearchMain;

public class FloatingWindow extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FloatingWindow()
	{
		JPanel cp = new JPanel();
//		setSize(50, 50);
		setContentPane(cp);
//		setLocationRelativeTo(null);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setType(JFrame.Type.UTILITY);
//		setFocusable(false);
		setAutoRequestFocus(false);
		setBackground(new Color(0, 0, 0, 0)); // 设置背景透明

		ImageIcon img = new ImageIcon("src/searchs.png");
		JLabel back = new JLabel(img);
		cp.add(back);
		back.setBounds(0, 0, 38, 38);

		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO 自动生成的方法存根
//				System.out.println("窗口消失了");
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO 自动生成的方法存根
				Robot robot = null;
				try
				{
					robot = new Robot();
				} catch (AWTException e1)
				{
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
//				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_C);
				robot.delay(220);
				System.out.println(Clipboard.getClipboardString());
				if (GrammarPanel.frame == null)
					GrammarPanel.openForm("https://www.php.net/" + Clipboard.getClipboardString(),
							Clipboard.getClipboardString(), GarmmarSearchMain.ReleaseX + 38,
							GarmmarSearchMain.ReleaseY - 12);
//				System.out.println(e.getX() + " " + e.getY());
//				GarmmarSearchMain.test.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO 自动生成的方法存根

			}
		});

	}
}
