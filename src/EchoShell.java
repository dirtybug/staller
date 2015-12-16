import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;

public class EchoShell extends Thread implements Command {

	private InputStream in;
	private OutputStream out;
	private ExitCallback callback;
	private Environment environment;
	private Thread thread;

	@Override
	public void destroy() {
		thread.interrupt();

	}

	@Override
	public void setErrorStream(OutputStream arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setExitCallback(ExitCallback callback) {
		this.callback = callback;

	}

	@Override
	public void setInputStream(InputStream in) {

		this.in = in;

	}

	@Override
	public void setOutputStream(OutputStream out) {
		this.out = out;

	}

	@Override
	public void start(Environment env) throws IOException {
		this.environment = env;
		this.thread = new Thread(this, "EchoShell");
		thread.start();

	}

	@Override
	public void run() {
		String Command = "";
		System.out.println("start");
		OSsimulator OsObjec = new OSsimulator(out);

		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		try {
			while (!Thread.currentThread().isInterrupted()) {
				int c;

				while (((c = r.read()) != -1) && (!Thread.currentThread().isInterrupted())) {
					char ch = (char) c;
					System.out.println(ch);
					out.write(ch);
					if (ch == '\n') {
						OsObjec.parse(Command);
						Command = "";
						out.write("\r\n".getBytes());

					} else {
						Command += ch;
					}

					out.flush();

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("exit");
			callback.onExit(0);
		}
	}
}
