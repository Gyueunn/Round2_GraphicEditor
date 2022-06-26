package camp.java.project2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import camp.java.project2.UsingTool.MyShape;

public class Clear { // 지우기 올클리어(전체지우기), 오브젝트 지우기, redo(이전 그린 것만 지우기), undo(돌린 값 받아오기) 
	//public static ArrayList <MyShape> stackList = new ArrayList<MyShape>(); //을
	
	
	
	
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("All")) {
        		System.out.println(UsingTool.shapeArrayList);//비워지기 전 
        		UsingTool.startP = null;
        		UsingTool.endP = null;
        		UsingTool.redoStack.push(UsingTool.shapeArrayList.get(UsingTool.shapeArrayList.size()-1));
        		UsingTool.shapeArrayList.clear();
        		GraphicEditor.myPanel.repaint();
        		//UsingTool.redoStack.clear(); //stack을 모두 초기화 
        		System.out.println(UsingTool.shapeArrayList);//비우고 난 뒤 
        	}
        	
        	else if(input.equals("Object")) {
        		
			}
        	
			else if(input.equals("Eraser")) {
				GraphicEditor.tool = "Eraser";
        		GraphicEditor.stroke = 15;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
			}
        	
        	else if(input.equals("<=")) {
        		if(UsingTool.shapeArrayList.size() > 0) {
        			UsingTool.redoStack.push(UsingTool.shapeArrayList.get(UsingTool.shapeArrayList.size()-1));
            		UsingTool.shapeArrayList.remove(UsingTool.shapeArrayList.size()-1);
            		UsingTool.startP = null;
            		GraphicEditor.myPanel.repaint();
            		System.out.println("push : " + UsingTool.redoStack);
        		}
			}
        	
        	else if(input.equals("=>")) {
        		if(!UsingTool.redoStack.empty()) {
        			UsingTool.shapeArrayList.add(UsingTool.redoStack.pop());
        			UsingTool.MyShape undo = UsingTool.shapeArrayList.get(UsingTool.shapeArrayList.size()-1);
//            		UsingTool.startP = undo.sp;
//            		UsingTool.endP = undo.ep;
            		System.out.println("pop : " + UsingTool.redoStack);
            		GraphicEditor.myPanel.repaint();
        		}
			}
        }
    };
}
