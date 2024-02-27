package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import classes.FloydRivestQuickselect;
import classes.IntegerComparator;
import classes.Quickselect;

public class Main {

	/**
	 * Examples for Quickselect and Floyd Rivest algorithm.
	 * By changing the two boolean values, you can decide which example to be executed.
	 *
	 * @param args arguments for calling main method
	 */
	public static void main(String[] args) {

		boolean callQuickselect = true;
		boolean callFloydRivest =true;

		if (callQuickselect){
			callQuickselect();
		}
		if(callFloydRivest){
			callFloydRivestQuickselect();
		}
	}

	/**
	 * Example for usage of quickselect algorithm.
	 */
	private static void callQuickselect(){
		System.out.println("Executing Quickselect algorithm.");

		Quickselect<Integer> quickselect = new Quickselect<>(new IntegerComparator());

		//new list with size 10 and random numbers between 1 and 50
		List<Integer> intList = new Random().ints(10, 1, 50).boxed().collect(Collectors.toList());

		//printing the initial state of the unordered list
		System.out.println(intList.toString() + "\n");

		//searching for the k-smallest element
		int k = new Random().nextInt(1, intList.size()-1);
		System.out.println("Searching " + k + "-th smallest element");
		System.out.println(quickselect.select(intList, k) + "\n");

		//printing the final state of the list (now partially ordered)
		System.out.println(quickselect.getList().toString());
		System.out.println("Quickselect algorithm done.");
		System.out.println("*****************************************");
	}

	/**
	 * Example for usage of Floyd-Rivest algorithm.
	 */
	private static void callFloydRivestQuickselect(){
		System.out.println("Executing Floyd-Rivest algorithm.");

		FloydRivestQuickselect f = new FloydRivestQuickselect();

		//new list with size 10 and random numbers between 1 and 50
		List<Integer> intList = new Random().ints(10, 1, 50).boxed().collect(Collectors.toList());

		//printing the initial state of the unordered list
		System.out.println(intList.toString() + "\n");

		//searching for the k-smallest element
		int k = new Random().nextInt(1, intList.size()-1);
		System.out.println("Searching " + k + "-th smallest element");
		System.out.println(f.select(intList,k ) + "\n");

		//printing the final state of the list (now partially ordered)
		System.out.println(intList.toString());
		System.out.println("Floyd-Rivest algorithm done.");
		System.out.println("*****************************************");
	}
}
