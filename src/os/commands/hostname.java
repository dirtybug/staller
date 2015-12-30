package os.commands;

import os.Commands;
import os.OSsimulator;

public class hostname extends Commands{
	public static String Name="hostname";

	public hostname( OSsimulator OS) {
		
		super(Name, OS);
		
	}

	@Override
	public void Action(String[] command) {
		if (command.length==1)
		{
			super.writeln(OS.Hostname);
		}
		if (command.length==2)
		{
			OS.Hostname=command[2];
		}

		
	}

}
