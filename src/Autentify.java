import java.security.KeyPair;

import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.session.ServerSession;

public class Autentify implements PasswordAuthenticator {

	@Override

	public boolean authenticate(String username, String password, ServerSession session) {

		System.out.println(username);
		System.out.println(password);
		KeyPair keys = session.getHostKey();
	
		

		return "julio".equals(username) && "a".equals(password);
	}

}
