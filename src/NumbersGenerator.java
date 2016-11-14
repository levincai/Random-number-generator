import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

public class NumbersGenerator {

	int[] numbers;
	private String[] numbersList;
	private String content;
	int i, max, min, limit;

	ProgramPanel values = new ProgramPanel();

	public void generate(int limit, int max, int min) throws IOException {

		numbers = new int[limit];
		numbersList = new String[limit];
		Random rand = new Random();
		for (i = 0; i < limit; i++) {
			numbers[i] = rand.nextInt(max - min + 1) + min;
			numbersList[i] = Integer.toString(numbers[i]);
		}

		content = String.join(" ", numbersList);

		try {
			// Whatever the file path is.
			File statText = new File("C://Users/rafal.matuszczak/Documents/RandomNumbers.txt");
			FileOutputStream is = new FileOutputStream(statText);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer w = new BufferedWriter(osw);
			w.write(content);
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}

	}

	public int[] displayNumber() {
		int[] number = numbers;
		return number;
	}

}
