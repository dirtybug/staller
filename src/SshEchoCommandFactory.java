import org.apache.sshd.common.Factory;
import org.apache.sshd.server.Command;

public class SshEchoCommandFactory implements Factory<Command> {

	@Override
	public Command create() {
		// TODO pase the username in to the echoShell
		String username="julio";

		return new EchoShell(username);
	}

}
