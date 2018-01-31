package command;

import java.util.LinkedList;

public class TestCommand {
	private LinkedList<Command> comands = new LinkedList<>();

	public boolean addCommand(Command command) {
		return comands.add(command);
	}

	public void run() {
		while (!comands.isEmpty()) {
			Command command = comands.getFirst();
			comands.removeFirst();
			command.execute();
		}
	}
}
