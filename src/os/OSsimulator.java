package os;

import java.io.IOException;
import java.io.OutputStream;

public class OSsimulator {

	private OutputStream out;

	public OSsimulator(OutputStream out) {
		this.out = out;
	}

	public void parse(String command) {
		try {
			out.write("error\r\n".getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
