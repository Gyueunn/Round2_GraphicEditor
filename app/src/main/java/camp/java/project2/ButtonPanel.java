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
	JPanel eraserPanel = new JPanel(); //지우기 
	JPanel widthPanel = new JPanel(); //굵기 
	JPanel colorPanel = new JPanel(); //색상 
	static JLabel outputAll = new JLabel();
	static JLabel outputSize = new JLabel();
	
	static JPanel colorCheck = new JPanel();//색상 확인용 
	
	public ButtonPanel() {
		setOutputPanel();
		setEraserPanel();
		setWidthPanel();
		setColorPanel();
		buttonPanel.add(outputPanel);
		buttonPanel.add(colorPanel);
		buttonPanel.add(widthPanel);
		buttonPanel.add(eraserPanel);
		GraphicEditor.frame.add(buttonPanel, BorderLayout.NORTH);
	}
	void setOutputPanel() {
		ResetChange r = new ResetChange();
		outputPanel.setLayout(new GridLayout(1, 2));
		outputAll = new JLabel(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke), JLabel.CENTER);
		outputAll.setFont(new Font("Arial", Font.PLAIN, 17));
		outputSize.setBounds(0, 0, 270, 70);
		outputPanel.add(outputAll, BorderLayout.CENTER);
		String resetButton = "Reset";
		JButton rButton = new JButton();
		rButton = new JButton(resetButton);
		outputPanel.add(rButton);
		rButton.addActionListener(r.listener);
	}
		
	void setEraserPanel() {
		Clear c = new Clear();
		//eraserPanel.setLayout(new GridLayout(1, 2));
		String[] eraserButton = {"All", "Eraser","<=", "=>"};
		JButton[] eButton = new JButton[eraserButton.length];
		for(int i=0; i<eraserButton.length; i++) {
			eButton[i] = new JButton(eraserButton[i]);
			eraserPanel.add(eButton[i]);
			eButton[i].addActionListener(c.listener);
		}
	}
	
	void setWidthPanel() {
		WidthChange w = new WidthChange();
		widthPanel.setLayout(new GridLayout(1, 4));
		String[] widthButton = {"-", "+"};
		JButton[] wButton = new JButton[widthButton.length];
		for(int i=0; i<widthButton.length; i++) {
			wButton[i] = new JButton(widthButton[i]);
			widthPanel.add(wButton[i]);
			wButton[i].addActionListener(w.listener);
		}
	}
	
	void setColorPanel() {
		ColorChange c = new ColorChange();
		colorPanel.setLayout(new GridLayout(1,0));
		
		String colorButton = "Color";	
		JButton check = new JButton();
		check = new  JButton(colorButton);
		colorCheck.setBackground(GraphicEditor.color);
		colorPanel.add(check);
		colorPanel.add(colorCheck);
		check.addActionListener(c.listener);
	}
}

	

