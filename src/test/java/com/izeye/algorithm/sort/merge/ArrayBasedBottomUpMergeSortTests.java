package com.izeye.algorithm.sort.merge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for array-based bottom-up merge sort.
 *
 * @author Johnny Lim
 */
public class ArrayBasedBottomUpMergeSortTests {

	@Test
	public void testSort() {
		int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] numbers = {3, 4, 2, 1, 7, 5, 8, 9, 0, 6};

		ArrayBasedBottomUpMergeSort.sort(numbers);
		assertThat(numbers).isEqualTo(expected);
	}

}
