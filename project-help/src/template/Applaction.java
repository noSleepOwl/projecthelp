package template;

abstract public class Applaction {
	abstract void init();

	abstract void idle();

	abstract void cleanUp();

	private boolean isDone = false;

	protected void setDone() {
		isDone = false;
	}

	private boolean done() {
		return isDone;
	}

	public void run() {
		init();
		while (!done())
			idle();
		cleanUp();
	}
}
