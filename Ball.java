import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private int dy = 0; 
	private int dx = 2;
	public Ball (int x, int y)
	{
		setLocation(x,y);
		setSize(40,40);
	}
	
	public void paintComponent (Graphics b)
	{
		Graphics2D b2 = (Graphics2D) b;
		Ellipse2D.Double ball = new Ellipse2D.Double(0,0,10,10);
		b2.setColor(Color.BLUE);
		b2.fill(ball);
	}
	
	public void setDY(int y)
	{
		dy=y;
	}
	public void setDX(int x)
	{
		dx=x;
	}
	public void update()
	{
		setLocation(getX()+dx, getY()+dy);
	}
}
