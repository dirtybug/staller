package os;

public abstract class Commands {
	private String name;
	public OSsimulator OS;
	public Commands(String name, OSsimulator OS)
	{
		this.name=name;
		this.OS=OS;
		
	}
	
	public boolean execute (String Arguments[] )
	{
		
		if (Arguments[0].equals(this.name))
		{
			Action(Arguments);
			return true;
		}
		
		
		return false;
		
	}
	abstract public void Action(String [] command);

	public void writeln(String text) {
		this.OS.writeLn(text);
		
	}


}
