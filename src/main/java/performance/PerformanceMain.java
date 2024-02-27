package performance;

import java.io.IOException;

import classes.FloydRivestQuickselect;
import classes.IntegerComparator;
import classes.Quickselect;

public class PerformanceMain {

	/**
	 * Main method to use the Performance Tester. The running times are saved to the
	 * user/documents folder.
	 *
	 * @param args arguments for calling main method
	 */
	public static void main(String[] args) throws IOException {

		boolean testQuickselect = false;
		boolean testFloydRivest = false;

		if (testQuickselect) {
			testQuickselect();
		}
		if (testFloydRivest) {
			testFloydRivest();
		}
	}

	private static void testQuickselect() {
		PerformanceTester<Integer> p = new PerformanceTester<Integer>(new Quickselect<Integer>(new IntegerComparator()),
				1000);
		PerformanceTester<Integer> pSmall = new PerformanceTester<Integer>(
				new Quickselect<Integer>(new IntegerComparator()), 100);

		p.executePerformanceTest(100000, 200000);
		System.out.println("TestDone");
		p.executePerformanceTest(200000, 400000);
		System.out.println("TestDone");
		p.executePerformanceTest(300000, 600000);
		System.out.println("TestDone");
		p.executePerformanceTest(400000, 800000);
		System.out.println("TestDone");
		p.executePerformanceTest(500000, 1000000);
		System.out.println("TestDone");
		p.executePerformanceTest(600000, 1200000);
		System.out.println("TestDone");
		p.executePerformanceTest(800000, 1600000);
		System.out.println("TestDone");
		p.executePerformanceTest(1000000, 2000000);
		System.out.println("TestDone");
		p.executePerformanceTest(2000000, 4000000);
		System.out.println("TestDone");
		p.executePerformanceTest(3000000, 6000000);
		System.out.println("TestDone");
		pSmall.executePerformanceTest(10000000, 20000000);
		System.out.println("allTestDone");
		System.out.println("Quickselect Performance Test done");
	}

	private static void testFloydRivest() {
		PerformanceTester<Integer> p = new PerformanceTester<Integer>(new FloydRivestQuickselect(), 1000);
		PerformanceTester<Integer> pSmall = new PerformanceTester<Integer>(new FloydRivestQuickselect(), 100);

		p.executePerformanceTest(100000, 200000);
		System.out.println("TestDone");
		p.executePerformanceTest(200000, 400000);
		System.out.println("TestDone");
		p.executePerformanceTest(300000, 600000);
		System.out.println("TestDone");
		p.executePerformanceTest(400000, 800000);
		System.out.println("TestDone");
		p.executePerformanceTest(500000, 1000000);
		System.out.println("TestDone");
		p.executePerformanceTest(600000, 1200000);
		System.out.println("TestDone");
		p.executePerformanceTest(800000, 1600000);
		System.out.println("TestDone");
		p.executePerformanceTest(1000000, 2000000);
		System.out.println("TestDone");
		p.executePerformanceTest(2000000, 4000000);
		System.out.println("TestDone");
		p.executePerformanceTest(3000000, 6000000);
		System.out.println("TestDone");
		pSmall.executePerformanceTest(10000000, 20000000);
		System.out.println("allTestDone");
		System.out.println("Floys-Rivewst Performance Test done");
	}
}
