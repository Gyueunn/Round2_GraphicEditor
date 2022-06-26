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
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsingTool extends JPanel {
	static Point startP = null;
	static Point endP = null;

	//public static Stack<MyShape> redoStack = new Stack<>();
	public static Stack<MyShape> redoStack = new Stack<>();
	public static ArrayList <MyShape> shapeArrayList = new ArrayList<MyShape>();
	public static ArrayList <Point> pointArrayList; //드래
	
	public UsingTool() {
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml); 
		this.addMouseMotionListener(ml);
		this.setBackground(Color.WHITE);
		GraphicEditor.myPanel.add(this);
	}	
	
	static class MyShape {
		 String shapeTool;
	     Color shapeColor;
	     int shapeStroke;
	     Point sp, ep;
	     ArrayList <Point> shapePoint = new ArrayList<Point>();

	     public MyShape(String shapeTool, Color shapeColor, int shapeStroke, Point sp, Point ep, ArrayList <Point> shapePoint) {
	         this.shapeTool = shapeTool;
	         this.shapeColor = shapeColor;
	         this.shapeStroke = shapeStroke;
	         this.sp = sp;
	         this.ep = ep;
	         for(int i=0; i<shapePoint.size(); i++) {
	        	 this.shapePoint.add(shapePoint.get(i));
	         }
	     }
	     public MyShape(String shapeTool, Color shapeColor, int shapeStroke, Point sp, Point ep) {
	         this.shapeTool = shapeTool;
	         this.shapeColor = shapeColor;
	         this.shapeStroke = shapeStroke;
	         this.sp = sp;
	         this.ep = ep;
	         this.shapePoint = null;
	     }
	     
//	     public MyShape(ArrayList <Point> shapePoint) {
//	    	 this.shapePoint = shapePoint;
//	     }
	}
	
	public void paintComponent(Graphics graphic){
		Graphics2D g = (Graphics2D) graphic;
		super.paintComponent(graphic);
		
		if(shapeArrayList.size() != 0){
			for(MyShape cshape: shapeArrayList){
				g.setStroke(new BasicStroke(cshape.shapeStroke,BasicStroke.CAP_ROUND,0));
				g.setColor(cshape.shapeColor);
				if(cshape.shapeTool.equals("Line")) g.drawLine(cshape.sp.x, cshape.sp.y, cshape.ep.x, cshape.ep.y);//그리다
				else if(cshape.shapeTool.equals("☐")) g.drawRect(Math.min(cshape.sp.x, cshape.ep.x), Math.min(cshape.sp.y, cshape.ep.y),Math.abs(cshape.ep.x - cshape.sp.x),Math.abs(cshape.ep.y - cshape.sp.y));
				else if(cshape.shapeTool.equals("◯")) g.drawOval(Math.min(cshape.sp.x, cshape.ep.x), Math.min(cshape.sp.y, cshape.ep.y),Math.abs(cshape.ep.x - cshape.sp.x),Math.abs(cshape.ep.y - cshape.sp.y));
				else if(cshape.shapeTool.equals("Pen")) {
					for(int i =0; i<cshape.shapePoint.size()-1; i++) {
						g.drawLine(cshape.shapePoint.get(i).x, cshape.shapePoint.get(i).y, cshape.shapePoint.get(i+1).x, cshape.shapePoint.get(i+1).y);
					}
				}
				else if(cshape.shapeTool.equals("Eraser")) {
					for(int i =0; i<cshape.shapePoint.size()-1; i++) {
						g.setColor(Color.WHITE);
						g.drawLine(cshape.shapePoint.get(i).x, cshape.shapePoint.get(i).y, cshape.shapePoint.get(i+1).x, cshape.shapePoint.get(i+1).y);
					}
				}
			}
		}
		
		if(startP != null) {
			g.setStroke(new BasicStroke(GraphicEditor.stroke,BasicStroke.CAP_ROUND,0));
			g.setColor(GraphicEditor.color);
			if(GraphicEditor.tool.equals("Line")) g.drawLine(startP.x, startP.y, endP.x, endP.y);	
			else if(GraphicEditor.tool.equals("☐")) g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
			else if(GraphicEditor.tool.equals("◯")) g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
			else if(GraphicEditor.tool.equals("Pen")) {
				for(int i =0; i<pointArrayList.size()-1; i++) {
					g.drawLine(pointArrayList.get(i).x, pointArrayList.get(i).y, pointArrayList.get(i+1).x, pointArrayList.get(i+1).y);
				}
			}
			else if(GraphicEditor.tool.equals("Eraser")) {
				for(int i =0; i<pointArrayList.size()-1; i++) {
					g.setColor(Color.WHITE);
					g.drawLine(pointArrayList.get(i).x, pointArrayList.get(i).y, pointArrayList.get(i+1).x, pointArrayList.get(i+1).y);
				}
			}
		}
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint();
			pointArrayList =  new ArrayList<Point>();
			pointArrayList.add(startP);
		}
		
		public void mouseDragged(MouseEvent e){
			endP = e.getPoint();
			pointArrayList.add(endP);
			repaint();
		}
		
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint();
			pointArrayList.add(endP);
			
			if(GraphicEditor.tool.equals("Pen") || GraphicEditor.tool.equals("Eraser")) {
				MyShape currentShape = new MyShape(GraphicEditor.tool, GraphicEditor.color, GraphicEditor.stroke, startP, endP, pointArrayList);
				shapeArrayList.add(currentShape);
			}
			
			//new MyShape(pointArrayList);
			else if (GraphicEditor.tool.equals("Line") || GraphicEditor.tool.equals("☐") || GraphicEditor.tool.equals("◯")){
				MyShape currentShape = new MyShape(GraphicEditor.tool, GraphicEditor.color, GraphicEditor.stroke, startP, endP);
				shapeArrayList.add(currentShape);
			}
			redoStack.clear();//화면이 눌리면 이전의 redo를 삭제 
			repaint(); 
		}
		
		public void mouseMoved(MouseEvent e){
			
		}
//		public void mouseEntered(MouseEvent e){
//			startP = e.getPoint();
//			endP = e.getPoint();
//		}
	}
}


