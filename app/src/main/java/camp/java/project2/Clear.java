package camp.java.project2;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import camp.java.project2.UsingTool.MyShape;

public class Clear { // 지우기 올클리어(전체지우기), 오브젝트 지우기, redo(이전 그린 것만 지우기), undo(돌린 값 받아오기) 
	static ArrayList <MyShape> allClearList = new ArrayList<MyShape>();
	static boolean check = false;
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) { 
        	String input = e.getActionCommand();
        	if(input.equals("All")) {
        		UsingTool.startP = null;
        		UsingTool.endP = null;
        		for(int i=0; i<UsingTool.shapeArrayList.size(); i++) {
        			allClearList.add(UsingTool.shapeArrayList.get(i));
   	         	}
        		FileChange.isLoaded = false;
        		UsingTool.shapeArrayList.clear();
        		GraphicEditor.frame.repaint();
        		UsingTool.redoStack.clear(); //stack을 모두 초기화 
        	}
        	
			else if(input.equals("Eraser")) {
				GraphicEditor.tool = "Eraser";
        		GraphicEditor.stroke = 15;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
			}
        	
        	else if(input.equals("<=")) {
        		if(allClearList.size() != 0) {
        			for(int i=0; i<allClearList.size(); i++) {
        				UsingTool.shapeArrayList.add(allClearList.get(i));
       	         	}
        			allClearList.clear();
        			GraphicEditor.frame.repaint();
        		}
        		else if(UsingTool.shapeArrayList.size() > 0) {
        			UsingTool.redoStack.push(UsingTool.shapeArrayList.get(UsingTool.shapeArrayList.size()-1));
            		UsingTool.shapeArrayList.remove(UsingTool.shapeArrayList.size()-1);
            		UsingTool.startP = null;
            		UsingTool.startP = null;
            		GraphicEditor.frame.repaint();
        		}
			}
        	
        	else if(input.equals("=>")) {
        		if(!UsingTool.redoStack.empty()) {
        			UsingTool.shapeArrayList.add(UsingTool.redoStack.pop());
        			UsingTool.MyShape undo = UsingTool.shapeArrayList.get(UsingTool.shapeArrayList.size()-1);
            		GraphicEditor.frame.repaint();
        		}
			}
        }
    };
}
