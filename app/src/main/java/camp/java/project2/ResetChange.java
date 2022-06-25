package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Reset")) {
        		GraphicEditor.tool = "Line";
        		GraphicEditor.color = "BLACK";
        		GraphicEditor.stroke = 5;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + GraphicEditor.color + " / " + Double.toString(GraphicEditor.stroke));
        	}
        }
    };
}
