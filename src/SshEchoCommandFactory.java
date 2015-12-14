import org.apache.sshd.common.Factory;
import org.apache.sshd.server.Command;

public class SshEchoCommandFactory implements Factory<Command> {

	@Override
	public Command create() {
		// TODO Auto-generated method stub

		return new EchoShell();
	}

}
