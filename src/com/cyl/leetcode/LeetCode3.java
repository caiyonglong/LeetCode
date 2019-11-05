package com.cyl.leetcode;

import java.util.IllegalFormatCodePointException;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            String str = "";
            for (int j = i; j < s.length(); j++) {
                str = s.substring(i, j);
                //如果子串str 包含s.charAt(j)，则结束循环
                if (str.contains(s.charAt(j) + "")) {
                    if (max < len) {
                        max = len;
                    }
                    break;
                } else {
                    //获取当前不重复的子串长
                    len = str.length() + 1;
                }
            }
            //对比max、len。赋值max
            if (max < len) {
                max = len;
            }
        }
        return max;
    }
}
