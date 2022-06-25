package camp.java.project2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicEditor extends JFrame {
	public static JFrame frame = new JFrame();
	public static JPanel myPanel = new JPanel();
	
	public static String tool = "Line";
	public static String color = "BLACK";
	public static int stroke = 5; //펜 굵기
	
	public GraphicEditor() {
		frame.setTitle("GraphicEditor");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		new MenuBar();
		new ButtonPanel();
		myPanel.setBackground(Color.MAGENTA);
		
//		myPanel.setBounds(0, 0, 50, 50);
		myPanel.setOpaque(true);
		myPanel.setLayout(new GridLayout(1,1));
		new UsingTool();
		frame.add(myPanel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GraphicEditor();
		
		
		//마우스를 클릭했을 때 속성에 따라 실행될 수 있는 클래스 호출
	}
}
