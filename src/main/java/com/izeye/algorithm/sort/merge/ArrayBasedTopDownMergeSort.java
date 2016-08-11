package com.izeye.algorithm.sort.merge;

/**
 * Array-based top-down merge sort.
 *
 * @author Johnny Lim
 */
public abstract class ArrayBasedTopDownMergeSort {

	private ArrayBasedTopDownMergeSort() {
	}

	public static void sort(int[] numbers) {
		splitMerge(numbers, 0, numbers.length, new int[numbers.length]);
	}

	private static void splitMerge(int[] numbers, int startIndex, int endIndex, int[] temp) {
		if (endIndex - startIndex < 2) {
			return;
		}
		int middleIndex = (endIndex + startIndex) / 2;
		splitMerge(numbers, startIndex, middleIndex, temp);
		splitMerge(numbers, middleIndex, endIndex, temp);
		merge(numbers, startIndex, middleIndex, endIndex, temp);
		System.arraycopy(temp, startIndex, numbers, startIndex, endIndex - startIndex);
	}

	private static void merge(
			int[] numbers, int startIndex, int middleIndex, int endIndex, int[] temp) {
		int leftIndex = startIndex;
		int rightIndex = middleIndex;
		for (int i = startIndex; i < endIndex; i++) {
			if (leftIndex < middleIndex &&
					(rightIndex >= endIndex || numbers[leftIndex] <= numbers[rightIndex])) {
				temp[i] = numbers[leftIndex];
				leftIndex++;
			}
			else {
				temp[i] = numbers[rightIndex];
				rightIndex++;
			}
		}
	}

}
