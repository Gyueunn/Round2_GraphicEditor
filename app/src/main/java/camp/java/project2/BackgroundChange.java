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
	       		GraphicEditor.Background = Color.WHITE;
	       		UsingTool.panel.setBackground(GraphicEditor.Background);
	       		UsingTool.panel.repaint();
	       	}
	       	else if(input.equals("Black")) {
	       		System.out.println("Background" + GraphicEditor.Background);
	       		GraphicEditor.Background = Color.BLACK;
	       		UsingTool.panel.setBackground(GraphicEditor.Background);
	       		UsingTool.panel.repaint();
	       	}
        	else if(input.equals("Green")) {
        		System.out.println("Background" + GraphicEditor.Background);
        		GraphicEditor.Background = Color.GREEN;
        		UsingTool.panel.setBackground(GraphicEditor.Background);
        		UsingTool.panel.repaint();
        	}
        }
	};
}
