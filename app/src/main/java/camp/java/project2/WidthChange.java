package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WidthChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("-")) {
        		GraphicEditor.stroke -= 1;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        	else if(input.equals("+")) {
        		GraphicEditor.stroke += 1;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
			}
        }
    };
}
