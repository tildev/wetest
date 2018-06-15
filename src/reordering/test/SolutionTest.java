package reordering.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import reordering.main.Solution;

/**
 * @author tildev
 * @date 2018. 6. 15.
 */
class SolutionTest {

	@Test
	void test() {
		Solution solution = new Solution();

		String ex = "aaa019a";
		String result = "a0a1a9a";
		assertEquals(result, solution.reorder(ex));
	}

	@Test
	void testOne() {
		Solution solution = new Solution();

		String ex = "abz09";
		String result = "a0b9z";
		assertEquals(result, solution.reorder(ex));
	}

	@Test
	void testTwo() {
		Solution solution = new Solution();

		String ex = "abzcc";
		String result = "abccz";
		assertEquals(result, solution.reorder(ex));
	}

	@Test
	void testThree() {
		Solution solution = new Solution();

		String ex = "09019";
		String result = "00199";
		assertEquals(result, solution.reorder(ex));
	}

	@Test
	void testFour() {
		Solution solution = new Solution();

		String ex = "aaaaa0";
		String result = "a0aaaa";
		assertEquals(result, solution.reorder(ex));
	}

}
