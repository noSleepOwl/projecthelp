package sort;

import java.util.Collections;
import java.util.List;

public class SortImpl extends AbstractBubleSort {
	private List<TestSorterElement> elements;

	public SortImpl(List<TestSorterElement> elements) {
		this.elements = elements;
		this.length = elements.size();
	}

	@Override
	protected void swap(int index) {
		Collections.swap(elements, index, index + 1);
	}

	@Override
	protected boolean outOfOrder(int index) {
		return elements.get(index).tes > elements.get(index + 1).tes;
	}

	@Override
	protected void after() {
		System.out.printf("after:%55s\n", elements);
	}

	@Override
	protected void before() {
		// System.out.printf("before:%54s\n", elements);
	}

}
