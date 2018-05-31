import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class SnakeObject extends JComponent
{
	private int dy=0, dx=0;
	public SnakeObject(int x, int y)
	{
		setLocation(x,y);
		setSize(20,20);
	}
	
	public void paintComponent (Graphics g)
	{
		Graphics2D g2= (Graphics2D) g;
		Ellipse2D.Double body1 = new Ellipse2D.Double(0,0,20,20);
		g2.setColor(Color.GREEN);
		g2.fill(body1);
	}
	
	public void setDY(int y)
	{
		dy=y;
	}
	public void setDX(int x)
	{
		dx=x;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public void update()
	{
		setLocation(getX()+dx, getY()+dy);
	}
}