package com.izeye.algorithm.sort.merge;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for list-based top-down merge sort.
 *
 * @author Johnny Lim
 */
public class ListBasedTopDownMergeSortTests {

	@Test
	public void testSort() {
		List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> numbers = Arrays.asList(3, 4, 2, 1, 7, 5, 8, 9, 0, 6);

		List<Integer> sorted = ListBasedTopDownMergeSort.sort(numbers);
		assertThat(sorted).isEqualTo(expected);
	}

}
