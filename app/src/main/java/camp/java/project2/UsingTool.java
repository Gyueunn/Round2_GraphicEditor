package camp.java.project2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsingTool extends JPanel {
	Point startP = null;
	Point endP = null;

	ArrayList <MyShape> shapeArrayList = new ArrayList<MyShape>(); // 끝점
	
	public UsingTool() {
		//리스너를 공통으로해야  변수들이 공유된다.
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
//		this.setBackground(Color.BLACK);
		GraphicEditor.myPanel.add(this);
	}	
	
	static class MyShape {
		 String shapeTool;
	     String shapeColor;
	     int shapeStroke;
	     Point sp, ep;

	     public MyShape(String shapeTool, String shapeColor, int shapeStroke, Point sp, Point ep) {
	         this.shapeTool = shapeTool;
	         this.shapeColor = shapeColor;
	         this.shapeStroke = shapeStroke;
	         this.sp = sp;
	         this.ep = ep;
	     }
	     public MyShape(Point sp, Point ep) {
	         this.sp = sp;
	         this.ep = ep;
	     }
	}
	
	public void paintComponent(Graphics graphic){
		Graphics2D g = (Graphics2D) graphic;
		super.paintComponent(graphic); // 부모 페인트호출
		
		
		
		if(shapeArrayList.size() != 0){
			for(MyShape cshape: shapeArrayList){
				
				g.setStroke(new BasicStroke(cshape.shapeStroke,BasicStroke.CAP_ROUND,0));
				 
				if(cshape.shapeColor.equals("BLACK")) g.setColor(Color.BLACK);
				else if(cshape.shapeColor.equals("RED")) g.setColor(Color.RED);
				else if(cshape.shapeColor.equals("BLUE")) g.setColor(Color.BLUE);
				
				if(cshape.shapeTool.equals("Line")) g.drawLine(cshape.sp.x, cshape.sp.y, cshape.ep.x, cshape.ep.y);//그리다
				else if(cshape.shapeTool.equals("☐")) g.drawRect(Math.min(cshape.sp.x, cshape.ep.x), Math.min(cshape.sp.y, cshape.ep.y),Math.abs(cshape.ep.x - cshape.sp.x),Math.abs(cshape.ep.y - cshape.sp.y));
				else if(cshape.shapeTool.equals("◯")) g.drawOval(Math.min(cshape.sp.x, cshape.ep.x), Math.min(cshape.sp.y, cshape.ep.y),Math.abs(cshape.ep.x - cshape.sp.x),Math.abs(cshape.ep.y - cshape.sp.y));
			}
		}
		
		if(startP != null) {
			if(GraphicEditor.tool.equals("Line")) g.drawLine(startP.x, startP.y, endP.x, endP.y);	
			else if(GraphicEditor.tool.equals("☐")) g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
			else if(GraphicEditor.tool.equals("◯")) g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
		}
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint();
		}
		
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint();
			new MyShape(startP, endP);
			MyShape currentShape = new MyShape(GraphicEditor.tool, GraphicEditor.color, GraphicEditor.stroke, startP, endP);
			shapeArrayList.add(currentShape);
			
			repaint(); 
		}
		
		public void mouseDragged(MouseEvent e){
			endP = e.getPoint();
			repaint();
		}
		
		public void mouseMoved(MouseEvent e){
			
		}
		
		public void mouseEntered(MouseEvent e){
			startP = e.getPoint();
			endP = e.getPoint();
			System.out.println("Come on");
		}
	}
}


