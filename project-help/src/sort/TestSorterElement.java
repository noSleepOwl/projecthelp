package sort;

public class TestSorterElement {
	public int tes;
	public boolean tag = false;

	@Override
	public String toString() {
		if (tag)
			return "[='" + tes + "'=]";
		return tes + "";

	}
}
