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

public class MenuBar extends JMenuBar {
	public MenuBar() {
		chageTool();
		GraphicEditor.frame.setJMenuBar(this);
	}
	
	void chageTool() {
		ToolChange t = new ToolChange();
		JMenu propertyMenu = new JMenu("Tool");
		JMenuItem line = new JMenuItem("Line");
		JMenuItem pen = new JMenuItem("Pen");
		JMenuItem rec = new JMenuItem("Rec");
		JMenuItem cir = new JMenuItem("Cir");
		propertyMenu.add(line);
		propertyMenu.add(pen);
		propertyMenu.add(rec);
		propertyMenu.add(cir);
		this.add(propertyMenu);
		line.addActionListener(t.listener);
		pen.addActionListener(t.listener);
		rec.addActionListener(t.listener);
		cir.addActionListener(t.listener);
	}
}
