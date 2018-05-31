import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
public class SnackObject extends JComponent
{
 
	public SnackObject()
	{
		setLocation((int) (Math.random()*475), (int) (Math.random()*475));
		setSize(10,10);
	}
 
	public void paintComponent(Graphics g)
	{
		Graphics2D g2= (Graphics2D) g;
		g2.setColor(Color.RED);
		Ellipse2D.Double body1= new Ellipse2D.Double(0,0,10,10);
		g2.fill(body1);
	}
}
