package camp.java.project2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBar extends JFrame {
	public MenuBar() {
		JMenuBar mb = new JMenuBar();

		JMenu propertyMenu = new JMenu("굵기");
		propertyMenu.add(new JMenuItem("+"));
		propertyMenu.add(new JMenuItem("-"));
		
		JMenu addMenu = new JMenu("색상");
		addMenu.add(new JMenuItem("Red"));
		addMenu.add(new JMenuItem("Blue"));
		
		mb.add(propertyMenu);
		mb.add(addMenu);
		GraphicEditor.frame.setJMenuBar(mb);
	}
}
