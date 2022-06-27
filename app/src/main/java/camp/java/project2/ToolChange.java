package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
	       	if(input.equals("Line")) {
	       		GraphicEditor.tool = input;
	       		GraphicEditor.stroke = 5;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
	       	}
	       	else if(input.equals("Pen")) {
	       		GraphicEditor.tool = input;
	       		GraphicEditor.stroke = 5;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
	       	}
        	else if(input.equals("Rec")) {
        		GraphicEditor.tool = "☐";
        		GraphicEditor.stroke = 5;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
        	}
        	else if(input.equals("Cir")) {
        		GraphicEditor.tool = "◯";
        		GraphicEditor.stroke = 5;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
        	}
        	else if(input.equals("Star")) {
        		GraphicEditor.tool = "star";
        		GraphicEditor.stroke = 5;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
        	}
        }
	};
}
