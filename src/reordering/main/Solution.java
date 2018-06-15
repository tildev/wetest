package reordering.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tildev
 * @date 2018. 6. 15.
 */
public class Solution {

	/**
	 * index 가 유효할 때만 append 된다.
	 * 
	 * @param list
	 * @param index
	 * @param sb
	 * @return
	 */
	public boolean isStringAppend(List<Character> list, int index, StringBuilder sb) {
		if (list.size() > index) {
			sb.append(list.get(index));
			return true;
		}
		return false;
	}

	/**
	 * fList(fisrtList) sList(secondList) 번갈아가며 값 하나씩 가져다가 String 만들기
	 * 
	 * @param fList
	 * @param sList
	 * @param strLen
	 * @return
	 */
	public String makeString(List<Character> fList, List<Character> sList, int strLen) {
		StringBuilder sb = new StringBuilder();
		boolean isflist = true;
		int fIndex = 0;
		int sIndex = 0;
		while (true) {
			if (isflist) {
				if (isStringAppend(fList, fIndex, sb)) {
					fIndex += 1;
				}
				isflist = false;
			} else {
				if (isStringAppend(sList, sIndex, sb)) {
					sIndex += 1;
				}
				isflist = true;
			}

			if (strLen == sb.toString().length()) {
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * firstValueIsInt 값에 따라 어떤 List가 fisrtList 인지 secondList 인지 정해진다.
	 * 
	 * @param intList
	 * @param chList
	 * @param strLen
	 * @param firstValueIsInt
	 * @return
	 */
	public String relocation(List<Character> intList, List<Character> chList, int strLen, boolean firstValueIsInt) {
		String result = null;
		if (firstValueIsInt) {
			result = makeString(intList, chList, strLen);
		} else {
			result = makeString(chList, intList, strLen);
		}
		return result;
	}

	/**
	 * 주어진 String 을 chList(char) 와 intList(int) 에 나누어 담기
	 * 
	 * @param s
	 * @param intList
	 * @param chList
	 * @return
	 */
	public void divideStringIntoTwoList(String s, List<Character> intList, List<Character> chList) {
		char impCh;
		for (int i = 0; i < s.length(); i++) {
			impCh = s.charAt(i);
			if (47 < impCh && impCh < 58) {
				intList.add(impCh);
			} else {
				chList.add(impCh);
			}
		}
	}

	/**
	 * 주어진 String 첫 글자가 int 값인가?
	 * 
	 * @param s
	 * @return
	 */
	public boolean isFirstValueInt(String s) {
		if (47 < s.charAt(0) && s.charAt(0) < 58) {
			return true;
		}
		return false;
	}

	/**
	 * list 오름차순 정렬 및 string 으로 변환
	 * 
	 * @param list
	 * @return
	 */
	public String listSortedAndToString(List<Character> list) {
		return list.stream().sorted(Comparator.naturalOrder()).map(Object::toString).collect(Collectors.joining());
	}

	/**
	 * s(stringValue) 받아다가 재정렬
	 * 
	 * @param s
	 * @return
	 */
	public String reorder(String s) {
		String result = null;

		List<Character> intList = new ArrayList<>();
		List<Character> chList = new ArrayList<>();

		if (s == null || s.equals("")) {
			return result;
		}

		boolean firstValueIsInt = isFirstValueInt(s);

		// intList chList 분리
		divideStringIntoTwoList(s, intList, chList);

		if (intList.size() != 0 && chList.size() != 0) {
			result = relocation(intList, chList, s.length(), firstValueIsInt);
		} else {
			if (chList.size() == 0) {
				result = listSortedAndToString(intList);
			} else {
				result = listSortedAndToString(chList);
			}
		}
		return result;
	}
}
