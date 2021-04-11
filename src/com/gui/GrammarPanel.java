package com.gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class GrammarPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JPanel webBrowserPanel;

	private JWebBrowser webBrowser;

	public static JFrame frame = null;

	public GrammarPanel(String url)
	{
		super(new BorderLayout());
		webBrowserPanel = new JPanel(new BorderLayout());
		webBrowser = new JWebBrowser();
		webBrowser.navigate(url);
		webBrowser.setButtonBarVisible(false);
		webBrowser.setMenuBarVisible(false);
		webBrowser.setBarsVisible(false);
		webBrowser.setStatusBarVisible(false);
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		add(webBrowserPanel, BorderLayout.CENTER);
	}

	public static void openForm(String url, String title, int x, int y)
	{
		NativeInterface.open();
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setTitle(title);
		// 设置窗体关闭的时候不关闭应用程序
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new GrammarPanel(url), BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationByPlatform(true);
		// 让窗体可见
		frame.setVisible(true);
		// 重置窗体大小
		frame.setResizable(true);
		// 设置窗体的宽度、高度
		frame.setBounds(x, y, 600, 600);
		// 设置窗体居中显示

		frame.addWindowListener(new WindowListener()
		{

			@Override
			public void windowOpened(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowIconified(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowDeiconified(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowDeactivated(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowClosed(WindowEvent e)
			{
				// TODO 自动生成的方法存根
				GrammarPanel.frame = null;
			}

			@Override
			public void windowActivated(WindowEvent e)
			{
				// TODO 自动生成的方法存根

			}
		});

	}

}