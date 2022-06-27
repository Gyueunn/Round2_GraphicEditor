package camp.java.project2;

import java.awt.AWTException;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileChange {
	static boolean isLoaded = false;
	static Image loadedImage;
	static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
	       	if(input.equals("Save")) {
	       		try {
					UsingTool.image = new Robot().createScreenCapture(new Rectangle(GraphicEditor.myPanel.getLocationOnScreen().x, GraphicEditor.myPanel.getLocationOnScreen().y, GraphicEditor.myPanel.getWidth(), GraphicEditor.myPanel.getHeight()));

				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	       		FileDialog fileDialogOpen = new FileDialog(GraphicEditor.frame, "파일 열기", FileDialog.SAVE);
                fileDialogOpen.setVisible(true);
                String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile() +".png";
	       		File file = new File(filePath);
				if (!file.exists())
			    try {
			    	file.createNewFile();
			    	} catch (IOException e1) {
			            // TODO Auto-generated catch block
			    		e1.printStackTrace();
			         }
			      try {
			         ImageIO.write(UsingTool.image, "png", file);
			      } catch (IOException e1) {
			         // TODO Auto-generated catch block
			    	  e1.printStackTrace();
			      }
	       	}
	       	
	       	else if(input.equals("Load")) {
	       		FileDialog fileDialogOpen = new FileDialog(GraphicEditor.frame, "파일 열기", FileDialog.LOAD);
                fileDialogOpen.setVisible(true);
                String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
                if(filePath.contains(".png")) {
                   try {
                      isLoaded =true;
                      loadedImage = ImageIO.read(new File(filePath));
                      GraphicEditor.myPanel.repaint();
                     } catch (IOException ex) {
                          // handle exception...
                     }
                }
		     }
	        
        }
	};
}

