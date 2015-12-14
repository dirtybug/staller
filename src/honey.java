import java.io.IOException;

import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;

public class honey {
	public static void startSshServer() throws IOException {

		SshServer sshServer = SshServer.setUpDefaultServer();
		sshServer.setPort(22);
		sshServer.setPasswordAuthenticator(new PasswordAuthenticator() {
			@Override
			public boolean authenticate(String username, String password, ServerSession session) {

				System.out.println(username);
				System.out.println(password);
				return "ssh".equals(username) && "secret".equals(password);
			}
		});
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
		}
		while (true) {

		}

	}

}