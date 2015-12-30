import java.io.IOException;

import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

public class honey {
	static SshServer sshServer;
	public static void startSshServer() throws IOException {

		sshServer = SshServer.setUpDefaultServer();

		sshServer.setPort(2232);
		sshServer.setPasswordAuthenticator(new Autentify());
		sshServer.setShellFactory(new SshEchoCommandFactory());
		
		sshServer.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());
		sshServer.start();

	}

	public static void main(String[] args) {
		try {
			startSshServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		while (true) {

		}

	}

}