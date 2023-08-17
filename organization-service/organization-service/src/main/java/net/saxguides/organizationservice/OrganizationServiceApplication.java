package net.saxguides.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@SpringBootApplication
//@EnableEurekaClient
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}


//	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
//		// Write your code here.
//		Collections.sort(array);
//		int firtElement = 0;
//		int LastElement = array.size() - 1;
//		ArrayList<Integer> newArr = new ArrayList<>();
//		ArrayList<Integer> newArr2 = new ArrayList<>();
//
//		while(firtElement < LastElement ) {
//			if(array.get(firtElement) == toMove) {
//				newArr.add(array.get(firtElement));
//			} else {
//				newArr2.add(array.get(firtElement));
//			}
//			firtElement ++;
//		}
//		newArr2.addAll(newArr);
//		return newArr2;
//	}
//
//	public static int minimumSwaps(String brackets) {
//		int swapCount = 0;
//		Stack<Integer> stack = new Stack<>();
//
//		for (int i = 0; i < brackets.length(); i++) {
//			char bracket = brackets.charAt(i);
//
//			if (bracket == '(') {
//				stack.push(i);
//			} else {
//				if (!stack.empty()) {
//					stack.pop();
//				} else {
//					int j = i + 1;
//					while (j < brackets.length() && brackets.charAt(j) != '(') {
//						j++;
//					}
//
//					if (j == brackets.length()) {
//						return -1;
//					}
//
//					swapCount += j - i;
//				}
//			}
//		}
//
//		if (!stack.empty()) {
//			return -1;
//		}
//
//		return swapCount;
//	}
//
//	public static int minimumSwaps(String brackets) { //(()))( expected is 1. not -1 //also this ))()(()(
//
//		int swapedCount = 0;
//		Stack<Character> stack = new Stack<>();
//		StringBuilder stringBuffer = new StringBuilder(brackets);
//
//		for (int i = 0; i < stringBuffer.length(); i++) {
//			char bracket = stringBuffer.charAt(i);
//
//			if (bracket == '(') {
//				stack.push(bracket);
//			} else {
//				if (!stack.empty()) {
//					stack.pop();
//				} else {
//					int j = i + 1;
//					while (j < stringBuffer.length() && stringBuffer.charAt(j) != '(') {
//						j++;
//					}
//					if (j == stringBuffer.length()) {
//						return -1;
//					}
//
//					stringBuffer.setCharAt(i, '(');
//					stringBuffer.setCharAt(i, ')');
//					swapedCount ++;
//					stack.push('(');
//				}
//			}
//		}
//		return stack.empty() ? swapedCount : -1;
//
//
//	}
//
//
//	public static int minimumSwaps(String brackets) {
//		int swapCount = 0, imbalance = 0;
//
//		for (int i = 0; i < brackets.length(); i++) {
//			char bracket = brackets.charAt(i);
//
//			if (bracket == '(') {
//				if (imbalance > 0) {
//					// Swap this opening bracket with a previous closing bracket
//					swapCount += imbalance;
//					imbalance--;
//				}
//			} else {
//				imbalance++;
//			}
//		}
//
//		return (imbalance == 0) ? swapCount : -1;
//	}
//
//
//	public static int minimumSwaps(String brackets) {
//		int openCount = 0;
//		int closeCount = 0;
//		for (int i = 0; i < brackets.length(); i++) {
//			if (brackets.charAt(i) == '(') {
//				openCount++;
//			} else {
//				closeCount++;
//			}
//		}
//		if (openCount != closeCount) {
//			return -1;
//		}
//
//		int imbalance = 0;
//		int swaps = 0;
//
//		for (int i = 0; i < brackets.length(); i++) {
//			if (brackets.charAt(i) == ')') {
//				if (imbalance > 0) {
//					imbalance--;
//				} else {
//					imbalance++;
//				}
//			} else {
//				if (imbalance > 0) {
//					swaps += imbalance;
//					imbalance--;
//				}
//			}
//		}
//
//		return swaps;
//	}
//
//
//	public static List<String> groupTransactions(String[] transactions) {
//		Map<String, Integer> map = new HashMap<>();
//		for (String transaction : transactions) {
//			map.put(transaction, map.getOrDefault(transaction, 0) + 1);
//		}
//
//		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
//		list.sort(new Comparator<Map.Entry<String, Integer>>() {
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//				if (!o1.getValue().equals(o2.getValue())) {
//					return o2.getValue() - o1.getValue();  // Sort by count descending
//				} else {
//					return o1.getKey().compareTo(o2.getKey());  // Sort by item name ascending
//				}
//			}
//		});
//
//		String[] result = new String[list.size()];
//		int index = 0;
//		for (Map.Entry<String, Integer> entry : list) {
//			result[index++] = entry.getKey() + " " + entry.getValue();
//		}
//		return List.of(result);
//	}
//}
}
