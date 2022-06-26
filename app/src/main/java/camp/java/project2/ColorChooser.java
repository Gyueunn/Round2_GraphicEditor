package camp.java.project2;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.colorchooser.ColorSelectionModel;

public class ColorChooser extends JFrame implements ChangeListener{
   JColorChooser colorChooser = new JColorChooser();
   static boolean colorChange;   
   @Override
   public void stateChanged(ChangeEvent e) {
      // TODO Auto-generated method stub
      GraphicEditor.color = colorChooser.getColor();
      colorChange = true;
      ButtonPanel.colorCheck.setBackground(GraphicEditor.color);
   }
   
   public ColorChooser(){
      setTitle("ColorChooser");
      setLocation(200, 150);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      colorChooser.getSelectionModel().addChangeListener(this);
      
      add(colorChooser);
      pack();
      setVisible(true);
   }

}