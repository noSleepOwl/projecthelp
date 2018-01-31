package sort;

public abstract class AbstractBubleSort {
	private int operations = 0;
	protected int length = 0;

	public int doSort() {
		if (length <= 1)
			return operations;
		for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
			for (int index = 0; index <= nextToLast; index++)
				if (outOfOrder(index)) {
					before();
					swap(index);
					after();
					operations++;
				}
		return operations;

	}

	protected abstract void after();

	protected abstract void before();

	protected abstract void swap(int index);

	protected abstract boolean outOfOrder(int index);
}
