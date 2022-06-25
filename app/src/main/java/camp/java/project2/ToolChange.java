package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
	       	if(input.equals("Line")) {
	       		GraphicEditor.tool = input;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
	       	}
	       	else if(input.equals("Pen")) {
	       		GraphicEditor.tool = input;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
	       	}
        	else if(input.equals("☐")) {
        		GraphicEditor.tool = input;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        	else if(input.equals("◯")) {
        		GraphicEditor.tool = input;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        }
	};
}
