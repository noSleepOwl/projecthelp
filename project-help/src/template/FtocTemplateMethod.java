package template;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FtocTemplateMethod extends Applaction {
	private BufferedReader bufferedReader;
	private InputStreamReader inputStreamReader;

	public static void main(String[] args) {
		new FtocTemplateMethod().run();
	}

	@Override
	void init() {
		inputStreamReader = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputStreamReader);
	}

	@Override
	void idle() {
		String fahrString = readLineAndReturnNummIfError();
		if (fahrString == null || fahrString.length() == 0) {
			setDone();
		} else {
			double fahrDouble = Double.parseDouble(fahrString);
			double celcius = 5.0 / 9.0 * (fahrDouble - 32);
			System.out.println("F=" + fahrDouble + ",C=" + celcius);
		}
	}

	@Override
	void cleanUp() {
		System.out.println("FtocTemplateMethod exect");
	}

	private String readLineAndReturnNummIfError() {
		String s;
		try {
			s = bufferedReader.readLine();
		} catch (Exception e) {
			s = null;
		}
		return s;
	}
}
