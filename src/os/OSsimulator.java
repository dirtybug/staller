package os;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import os.FS.folder;
import os.commands.hostname;
import os.commands.ls;

public class OSsimulator {

	private OutputStream out;
	String username = "";
	String Folder = "";
	String Hostname = "HoneyPot";

	private String comandPropt = "$~:";
	Map<String, Commands> CommandsMap;
	private folder fileSys;

	public OSsimulator(OutputStream out, String username) {
		this.out = out;
		this.username = username;
		this.fileSys=new folder();
		CommandsMap = new HashMap();
		CommandsMap.put(ls.Name, new ls(this));
		CommandsMap.put(hostname.Name, new hostname(this));
	}

	void ChangeHostName(String Hostname) {
		this.Hostname = Hostname;

	}

	public void parse(String command) {
		try {
			// out.write(command.getBytes());
			// out.flush();
			out.write("\n\r".getBytes());
			out.flush();
			System.out.println(command);
			// TODO:command line simulator here
			if (CommandsMap.containsKey(command)) {
				CommandsMap.get(command);
			} else {

				writeLn("invalid command");
			}

			out.write(printTerm().getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void writeLn(String text) {
		try {
			out.write((text + "\n\r").getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String printTerm() {
		return username + "#" + Hostname + comandPropt;

	}

}
