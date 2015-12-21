import java.io.IOException;
import java.io.OutputStream;

public class OSsimulator {

	private OutputStream out;
	String username="";
	String Folder="";
	String Hostname="HoneyPot";
	
	private String comandPropt="$~:";

	public OSsimulator(OutputStream out, String username) {
		this.out = out;
		this.username=username;
	}



	public void parse(String command) {
		try {
			//out.write(command.getBytes());
			//out.flush();
			out.write("\n\r".getBytes());
			out.flush();
			System.out.println(command);
			//TODO:command line simulator here
			
			
			
			
			out.write(printTerm().getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	public String printTerm()
	{
		return username+"#"+Hostname+comandPropt;
		
	}

}
