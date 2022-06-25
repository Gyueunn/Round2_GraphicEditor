package camp.java.project2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JFrame {
	JPanel buttonPanel = new JPanel(); // 기준
	JPanel outputPanel = new JPanel();
	JPanel drawPanel = new JPanel(); // 도형 
	JPanel eraserPanel = new JPanel(); //지우기 
	JPanel widthPanel = new JPanel(); //굵기 
	JPanel colorPanel = new JPanel(); //색상 
	static JLabel outputAll = new JLabel();
	static JLabel outputSize = new JLabel();
	
	public ButtonPanel() {
		setOutputPanel();
		setDrawPanel();
		setEraserPanel();
		setWidthPanel();
		setColorPanel();
		outputPanel.setPreferredSize(new Dimension(150, 40));
		drawPanel.setPreferredSize(new Dimension(130, 40));
		eraserPanel.setPreferredSize(new Dimension(130, 40));
		widthPanel.setPreferredSize(new Dimension(80, 40));
		colorPanel.setPreferredSize(new Dimension(150, 40));
		buttonPanel.add(outputPanel);
		buttonPanel.add(drawPanel);
		buttonPanel.add(widthPanel);
		buttonPanel.add(colorPanel);
		buttonPanel.add(eraserPanel);
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		GraphicEditor.frame.add(buttonPanel, BorderLayout.NORTH);
		//System.out.println(buttonPanel.getWidth());
		
	}
	void setOutputPanel() {
		ResetChange r = new ResetChange();
		outputPanel.setLayout(new GridLayout(2, 1));
		outputAll = new JLabel(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke), JLabel.CENTER);
		outputAll.setFont(new Font("Arial", Font.PLAIN, 15));
		outputSize.setBounds(0, 0, 270, 70);
		outputPanel.add(outputAll, BorderLayout.CENTER);
		String resetButton = "Reset";
		JButton rButton = new JButton();
		rButton = new JButton(resetButton);
		outputPanel.add(rButton);
		rButton.addActionListener(r.listener);
	}
	
	void setDrawPanel() {
		ToolChange t = new ToolChange();
		drawPanel.setLayout(new GridLayout(2, 2));
		String[] drawButton = {"Line", "Pen", "☐", "◯"};
		JButton[]drawJButton = new JButton[drawButton.length];
		for(int i=0; i<drawButton.length; i++) {
			drawJButton[i] = new  JButton(drawButton[i]);
			drawPanel.add(drawJButton[i]);
			drawJButton[i].addActionListener(t.listener);
		}
	}
	
	void setEraserPanel() {
		eraserPanel.setLayout(new GridLayout(2, 2));
		String[] eraserButton = {"AC", "CLEAR", "<=", "=>"};
		JButton[] eButton = new JButton[eraserButton.length];
		for(int i=0; i<eraserButton.length; i++) {
			eButton[i] = new JButton(eraserButton[i]);
			eraserPanel.add(eButton[i]);
		}
	}
	
	void setWidthPanel() {
		WidthChange w = new WidthChange();
		widthPanel.setLayout(new GridLayout(2, 2));
		String[] widthButton = {"+", "-"};
		JButton[] wButton = new JButton[widthButton.length];
		for(int i=0; i<widthButton.length; i++) {
			wButton[i] = new JButton(widthButton[i]);
			widthPanel.add(wButton[i]);
			wButton[i].addActionListener(w.listener);
		}
	}
	
	void setColorPanel() {
		ColorChange c = new ColorChange();
		colorPanel.setLayout(new GridLayout(2, 2));
		String[] colorButton = {"BLACK", "RED", "BLUE", "GREEN"};	
		 JButton[] check = new JButton[colorButton.length];
		//colorPanel.setBackground(Color.LIGHT_GRAY);
		for(int i=0; i<colorButton.length; i++) {
			check [i] = new  JButton(colorButton[i]);
			colorPanel.add(check [i]);
			check [i].addActionListener(c.listener);
		}
	}
}

	

