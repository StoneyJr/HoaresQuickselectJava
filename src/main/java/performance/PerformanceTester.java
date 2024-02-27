package performance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import classes.SelectAlgorithm;

public class PerformanceTester<T> {

	private final static String ROOT_DOCUMENTS = System.getProperty("user.home") + File.separator + "documents";

	private final SelectAlgorithm<Integer> selectAlgorithm;
	private int testCount;

	public PerformanceTester(SelectAlgorithm<Integer> algorithm, int testCount) {

		this.selectAlgorithm = algorithm;
		this.testCount = testCount;
	}

	public void executePerformanceTest(int listLength, int maxNumber) {

		String PerformanceFileName = this.selectAlgorithm.getClass().getSimpleName() + "_performanceTestLength"
				+ listLength + "_Max" + maxNumber + ".csv";
		String FileLocation = ROOT_DOCUMENTS + File.separator + PerformanceFileName;

		for (int i = 0; i < this.testCount; i++) {
			List<Integer> intList = new Random().ints(listLength, 0, maxNumber + 1).boxed()
					.collect(Collectors.toList());

			long preTime = System.nanoTime();
			Object kthInt = this.selectAlgorithm.select(intList, new Random().nextInt(1, intList.size() - 1));
			long postTime = System.nanoTime();

			try (Writer writer = new FileWriter(FileLocation, true)) {
				writer.write((postTime - preTime) + "\n");
			} catch (IOException e) {
				System.out.println("Invalid file name!");

			}
			System.out.println("Test " + (i + 1) + ": Done --- " + kthInt);
		}

	}

}
