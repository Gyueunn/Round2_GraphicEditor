package camp.java.project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicEditor extends JFrame {
	static JFrame frame = new JFrame();
	MenuBar menuBar = new MenuBar();
	ButtonPanel buttonPanel = new ButtonPanel();
	
	public static Double penWidth = 8.0; //펜 굵기 
	public static String tool = "Line";
	public static String color = "BLACK";
	
	GraphicEditor() {
		frame.setTitle("GraphicEditor");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GraphicEditor();
		//마우스를 클릭했을 때 속성에 따라 실행될 수 있는 클래스 호출 
		
	}
}
