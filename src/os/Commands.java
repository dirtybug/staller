package os;

public abstract class Commands {
	private String name;
	Commands(String name)
	{
		this.name=name;
	}
	
	boolean parse (String intruction)
	{
		String[] args = intruction.split(" ");
		if (args[0].equals(this.name))
		{
			Action(args);
			return true;
		}
		
		
		return false;
		
	}
	abstract void Action(String [] command);


}
