package com.izeye.algorithm.sort.merge;

/**
 * Array-based bottom-up merge sort.
 *
 * @author Johnny Lim
 */
public abstract class ArrayBasedBottomUpMergeSort {

	private ArrayBasedBottomUpMergeSort() {
	}

	public static void sort(int[] numbers) {
		int n = numbers.length;
		int[] temp = new int[n];

		for (int width = 1; width < n; width *= 2) {
			for (int i = 0; i < n; i += width * 2) {
				merge(numbers, i, Math.min(i + width, n), Math.min(i + width * 2, n), temp);
			}
			System.arraycopy(temp, 0, numbers, 0, n);
		}
	}

	private static void merge(
			int[] numbers, final int leftStartIndex, final int rightStartIndex, final int endIndex,
			int[] temp) {
		int leftIndex = leftStartIndex;
		int rightIndex = rightStartIndex;
		for (int i = leftStartIndex; i < endIndex; i++) {
			if (leftIndex < rightStartIndex &&
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
