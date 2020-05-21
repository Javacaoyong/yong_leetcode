package com.yong.leetcode.yong_leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @Description: 两数之和
* @author Yong 
* @date 2020年5月20日 下午9:52:12
 */
public class Leetcode_1 {
	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
              你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	示例:
		给定 nums = [2, 7, 11, 15], target = 9
		因为 nums[0] + nums[1] = 2 + 7 = 9
		所以返回 [0, 1]
	 */
	
	public static void main(String[] args) {
		int[] a = {2, 7, 11, 15};
		System.out.println(Arrays.toString(myLeetcode(a, 9)));
	}
	
	/**
	 *  暴力方式 使用两次循环  遍历任意两数之和=target  空间复杂度为 n * n
	 *  力扣执行结果  耗时71ms 内存40.1 MB
	 */
	public static int[] myLeetcode(int[] nums, int target) {
		int length = nums.length;
		int[] result = new int[2];
		if(length > 1) {
			int i , j;
			for(i = 0; i < length; i++) {
				for(j = i + 1; j < length; j++) {
					if(nums[i] + nums[j] == target) {
						result[0] = i;
						result[1] = j;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 *  高阶解法 使用hash桶作为容器 将hash的key设置为(target - 每次遍历的数值)  value作为该数值的下标
	 *  这样只要在hash桶中找到 满足条件的key使得  key = target - 每次遍历的数值 ===> target = key + 每次遍历的数值
	 *  空间复杂度为 n   耗时2ms 内存40.1 MB
	 *  
	 */
	public static int[] leetcode(int[] nums, int target) {
		int length = nums.length;
		int[] result = new int[2];
		if(length > 1) {
			Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
			int i;
			for(i = 0; i < nums.length; i++) {
				if(maps.containsKey(nums[i])) {
					result[0] = maps.get(nums[i]);
					result[1] = i;
					break;
				}
				maps.put(target - nums[i], i);
			}
		}
		return result;
	}
}
