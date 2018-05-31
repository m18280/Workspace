import java.util.ArrayList;

public class BodyPartsCollection
{
	private ArrayList <SnakeObject> body;
	private ArrayList <Direction> direction;

	
	public BodyPartsCollection()
	{
		body= new ArrayList <SnakeObject>();
		direction = new ArrayList <Direction>();
	
	}
	
	public void addInitial(SnakeObject snake)
	{
		body.add(snake);
		
	}
	
	public ArrayList <Direction> getit(ArrayList <Direction> direction)
	{
		return this.direction;
	}
	
	public void add()
	{
		if(body.get(0).getDX()!=0)
		{
			body.add(new SnakeObject(body.get(body.size()-1).getX()+20, body.get(body.size()-1).getY()));
		}
		else if(body.get(0).getDY()!=0)
		{
			body.add(new SnakeObject(body.get(body.size()-1).getX(), body.get(body.size()-1).getY()+20));
		}
	}
	
	public void move()
	{
		if(body.size()>1)
		{
			for(int i=2; i<body.size();i++)
			{
				body.get(i).setDX(body.get(1).getDX());
				body.get(i).setDY(body.get(1).getDY());
				if(body.get(i).getX()== direction.get(direction.size()-1).getX() &&body.get(i).getY()== direction.get(direction.size()-1).getY());
					{
						String current= direction.get(direction.size()-1).getDirection();
						if(current.equals("up"))
						{
							body.get(i).setDY(2);
							body.get(i).setDX(0);
						}
						if(current.equals("down"))
						{
							body.get(i).setDY(-2);
							body.get(i).setDX(0);
						}
						if(current.equals("left"))
						{
							body.get(i).setDY(0);
							body.get(i).setDX(-2);
						}
						if(current.equals("right"))
						{
							body.get(i).setDY(0);
							body.get(i).setDX(2);
						}
					}
			}
		}
	
		
	}
}