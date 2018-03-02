import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private Ball ball;
	private ArrayList<Ball> bunch;
	
	public WalkingFrame()
	{
		setBounds(100,100,600,400);
		setLayout(null);
		man= new Man(0,0);
		add(man);
		bunch = new ArrayList <Ball>();
		Timer timer = new Timer (10,this);
		timer.start();
		addKeyListener (new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode()==e.VK_O)
						{
							ball = new Ball(man.getX(),man.getY());
							bunch.add(ball);
							add(ball);
						}
						if (e.getKeyCode()==e.VK_W)
						{
							man.setDY(-2);
						}
						
						if (e.getKeyCode()==e.VK_S)
						{
							man.setDY(2);
						}
						
						if (e.getKeyCode()==e.VK_A)
						{
							man.setDX(-2);
						}
						
						if (e.getKeyCode()==e.VK_D)
						{
							man.setDX(2);
						}
						
					}

					@Override
					public void keyReleased(KeyEvent e) 
					{
						if(e.getKeyCode()==e.VK_O)
						{
							
						}
						if (e.getKeyCode()==e.VK_W)
						{
							man.setDY(0);
						}
						
						if (e.getKeyCode()==e.VK_S)
						{
							man.setDY(0);
						}
						
						if (e.getKeyCode()==e.VK_A)
						{
							man.setDX(0);
						}
						
						if (e.getKeyCode()==e.VK_D)
						{
							man.setDX(0);
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
	
	public static void main(String[] args)
	{
		new WalkingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		man.update(); 
		
		for(int i = bunch.size()-1; i>=0; i--)
		{
			if(bunch.get(i).getX()>this.getWidth())
			{
				bunch.get(i).remove(ball);
				remove(bunch.get(i));
			}
		}
		
		for(int i = bunch.size()-1; i>=0; i--)
		{
			bunch.get(i).update();
		}
		
		repaint();
	}
}