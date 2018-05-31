import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Background extends JFrame implements ActionListener
{
	private SnakeObject snake;
	private SnackObject snackie;
	private BodyPartsCollection bodyparts;
	private ArrayList <Direction> direct;
	private JFrame thisFrame=this;
	private int count=0;
	public Background()
	{
		this.setBounds(300,300,500,500);
		setLayout(null);
		snake= new SnakeObject (0,0);
		add(snake);
		bodyparts= new BodyPartsCollection();
		bodyparts.addInitial(snake);
		this.direct=bodyparts.getit(direct);
		snackie= new SnackObject();
		add(snackie);
		Timer timer= new Timer(15, this);
		timer.start();
		
		addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==e.VK_W)
				{
					snake.setDY(-2);
					snake.setDX(0);
					direct.add(new Direction(snake.getX(), snake.getY(), "up"));
					bodyparts.move();
				}
				if(e.getKeyCode()==e.VK_S)
				{
					snake.setDY(2);
					snake.setDX(0);
					direct.add(new Direction(snake.getX(), snake.getY(), "down"));
					bodyparts.move();
				}
				if(e.getKeyCode()==e.VK_A)
				{
					snake.setDX(-2);
					snake.setDY(0);
					direct.add(new Direction(snake.getX(), snake.getY(), "left"));
					bodyparts.move();
				}
				if(e.getKeyCode()==e.VK_D)
				{
					snake.setDX(2);
					snake.setDY(0);
					direct.add(new Direction(snake.getX(), snake.getY(), "right"));
					bodyparts.move();
				}
				
				}


			@Override
			public void keyReleased(KeyEvent e) 
			{	
				if(e.getKeyCode()==e.VK_W)
				{
				
				}
				if(e.getKeyCode()==e.VK_S)
				{
					
				}
				if(e.getKeyCode()==e.VK_A)
				{
				
				}
				if(e.getKeyCode()==e.VK_D)
				{
				
				}
			}

			@Override
			public void keyTyped(KeyEvent e) 
			{
				
			}
				
			});
			
				
		
		
		
		
		
		
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void reset()
	{
		snake.setDX(0);
		snake.setDY(0);
		count=0;
		snake.setLocation(0,0);
	}
	
	
	public static void main(String[] args)
	{
		new Background();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		snake.update();
		
			if(snake.getX() >= this.getWidth()||snake.getX()<0)
				{
					JOptionPane.showMessageDialog(thisFrame, "You Lose!");
					this.reset();
				}
			else if(snake.getY()>=this.getHeight()||snake.getY()<0)
				{
					JOptionPane.showMessageDialog(thisFrame, "You Lose!");
					this.reset();
				}
			
			
			if(snake.getY()<(snackie.getY()+snackie.getHeight())&& snake.getX()<snackie.getX()+snackie.getWidth() &&(snake.getX()+snake.getWidth()>snackie.getX())&&snake.getY()+snake.getHeight()>snackie.getY())
			{
				remove(snackie);
				setVisible(false);
				snackie= new SnackObject();
				add(snackie);
				bodyparts.add();
				setVisible(true);
			}
		repaint();
		
	}
	

	
	

}
