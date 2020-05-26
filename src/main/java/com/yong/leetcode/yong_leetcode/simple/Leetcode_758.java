/**
 * 
 */
package com.yong.leetcode.yong_leetcode.simple;

import java.util.Arrays;
import java.util.Comparator;

/**
* @Description: 字符串中的加粗单词
* @author Yong 
* @date 2020年5月21日 下午10:15:40
 */
public class Leetcode_758 {
	
	/**
	 * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
	       返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
	 
	  例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。
	  注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。	  
	 */
	public static void main(String[] args) {
		String[] words = {"ab", "bc"};
		String s = "aabcd";
		System.out.println(leetcode(words, s));
		
	}
	
	/**
	 * 使用boolean数组记录加粗下标 最后遍历isBold观察是进入加粗区域还是出加粗区域进行添加符号
	 * 注意S的第一个字符是加粗和最后一个字符是加粗的情况
	 * 力扣执行结果  耗时6ms 内存38.5 MB
	 */
	public static String leetcode(String[] words, String s) {
		//创建一个boolean数组 长度为s.length  加粗位置为true 不加粗位置为false
		boolean[] isBold = new boolean[s.length()];
		for(String word : words) {
			int n = s.indexOf(word, 0);
			while(n != -1) {
				for(int i = n; i < n + word.length(); i++) {
					isBold[i] = true;
				}
				n = s.indexOf(word, n + 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		//判断第一个
		if(isBold[0]) {
			sb.append("<b>");
		}
		for(int i = 0; i < isBold.length; i++) {
			sb.append(s.charAt(i));
			//判断最后一个
			if(i == isBold.length - 1) {
				if(isBold[i]) {
					sb.append("</b>");
				} 
				break;
			}	
			//如果前加粗后不加粗 说明结束
			if(isBold[i] && !isBold[i + 1]) {
				sb.append("</b>");
			}
			//如果前不加粗后加粗 说明开始
			if(!isBold[i] && isBold[i + 1]) {
				sb.append("<b>");
			}
		}
		return sb.toString();
	}
}
