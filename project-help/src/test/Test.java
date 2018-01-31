package test;

import java.util.ArrayList;
import java.util.List;

import sort.SortImpl;
import sort.TestSorterElement;

public class Test {
	public static void main(String[] args) {
		List<TestSorterElement> element = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			TestSorterElement ts = new TestSorterElement();
			ts.tes = (int) (Math.random() * 100);
			element.add(ts);
		}
		element.get(0).tag = true;
		new SortImpl(element).doSort();
	}

}
