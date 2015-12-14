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
		System.out.println("start");
		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		try {
			while (!Thread.currentThread().isInterrupted()) {

				String s = r.readLine();
				if (s == null) {
					return;
				}
				System.out.println(s);
				out.write((s + "\r\n").getBytes());
				out.flush();
				if ("exit".equals(s)) {
					return;
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
