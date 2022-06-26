package camp.java.project2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
	       	if(input.equals("White")) {
	       		System.out.println("Background" + GraphicEditor.Background);
	       		//new GraphicEditor();
	       		GraphicEditor.Background = Color.WHITE;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
	       	}
	       	else if(input.equals("Black")) {
	       		System.out.println("Background" + GraphicEditor.Background);
	       		//new GraphicEditor();
	       		GraphicEditor.Background = Color.BLACK;
	       		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
	       	}
        	else if(input.equals("Green")) {
        		System.out.println("Background" + GraphicEditor.Background);
        		//new GraphicEditor();
        		GraphicEditor.Background = Color.GREEN;
        		ButtonPanel.outputAll.setText(GraphicEditor.tool + " / " + Double.toString(GraphicEditor.stroke));
        	}
        }
	};
}
