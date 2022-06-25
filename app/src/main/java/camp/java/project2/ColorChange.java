package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
	       	if(input.equals("BLACK")) {
	       		GraphicEditor.color = input;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
	       	}
	       	else if(input.equals("RED")) {
	       		GraphicEditor.color = input;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
	       	}
        	else if(input.equals("BLUE")) {
        		GraphicEditor.color = input;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        	else if(input.equals("GREEN")) {
        		GraphicEditor.color = input;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        }
	};
}
