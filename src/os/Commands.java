package os;

public abstract class Commands {
	private String name;
	private OSsimulator OS;
	public Commands(String name, OSsimulator OS)
	{
		this.name=name;
		this.OS=OS;
		
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
	abstract public void Action(String [] command);


}
