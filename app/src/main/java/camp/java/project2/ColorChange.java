package camp.java.project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChange {
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	new ColorChooser();
        }
	};
}



