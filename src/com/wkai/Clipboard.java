package com.wkai;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Clipboard
{
	public static String getClipboardString()
	{
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		if (contents != null)
		{
			if (contents.isDataFlavorSupported(DataFlavor.stringFlavor))
			{
				String text = null;
				try
				{
					text = (String) contents.getTransferData(DataFlavor.stringFlavor);
				} catch (UnsupportedFlavorException e)
				{
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				return text;
			}
		}
		return null;
	}

	public static void setClipboardString(String text)
	{
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// ��װ�ı�����
		Transferable contents = new StringSelection(text);
		// ���ı��������õ�ϵͳ������
		clipboard.setContents(contents, null);
	}
}
