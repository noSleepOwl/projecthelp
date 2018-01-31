package command;

public class Delay implements Command {
	private long itsDelay;
	private char itsChar;
	private static TestCommand com = new TestCommand();
	private static boolean stop = false;

	public Delay(long itsDelay, char itsChar) {
		this.itsDelay = itsDelay;
		this.itsChar = itsChar;
	}

	public static void main(String[] args) {

		Command command = () -> stop = true;
		com.addCommand(new Delay(100, '1'));
		com.addCommand(new Delay(300, '3'));
		com.addCommand(new Delay(400, '5'));
		com.addCommand(new Delay(700, '7'));
		com.addCommand(new SleepCommand(2000, com, command));
		com.run();
	}

	@Override
	public void execute() {
		System.out.println(itsChar);
		if (!stop)
			depayAndRepeat();
	}

	private void depayAndRepeat() {
		com.addCommand(new SleepCommand(itsDelay, com, this));
	}

}

class SleepCommand implements Command {
	private long sleepTime;
	private TestCommand testCommand;
	private Command weakUp;
	private long startTime;
	private boolean started = false;

	public SleepCommand(long sleepTime, TestCommand testCommand, Command weakUp) {
		this.sleepTime = sleepTime;
		this.testCommand = testCommand;
		this.weakUp = weakUp;
	}

	@Override
	public void execute() {

		long currentTime = System.currentTimeMillis();
		if (!started) {
			System.out.println("启动");
			started = true;
			startTime = currentTime;
			testCommand.addCommand(this);
		} else if ((currentTime - startTime) < sleepTime) {
			// System.out.println("休眠");
			testCommand.addCommand(this);
		} else {
			System.out.println("唤醒");
			testCommand.addCommand(weakUp);
		}
	}

}

class TestSleepCommand {

	private boolean commandExecute = false;

	public void testSleep() throws Exception {
		Command weakUp = () -> {
			commandExecute = true;
		};
		TestCommand testCommand = new TestCommand();
		SleepCommand sleepCommand = new SleepCommand(1000, testCommand, weakUp);
		testCommand.addCommand(sleepCommand);
		long start = System.currentTimeMillis();
		testCommand.run();
		long stop = System.currentTimeMillis();
		long sleepTime = (stop - start);
		System.out.println("休眠了" + sleepTime + "毫秒");
	}
}
