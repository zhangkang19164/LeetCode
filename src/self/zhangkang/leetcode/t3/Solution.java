package self.zhangkang.leetcode.t3;

import java.util.Random;

/**
 * Created on 2019/5/8
 * Title: 无重复字符的最长子串
 * Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
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
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Android-张康
 * update 2019/5/8
 */
public class Solution {
    /**
     * 思路
     * 从第一位开始向后查找没有重复字符的子串，
     * 然后在找到的子串中查找最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //先判断是否为空，如果为空返回0
        if (null == s || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int tempLength;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //查找和当前起始位置相同字符位置
            tempLength = getFirstIndex(chars, i, chars.length);
            //在该子串中查找最长子串
            for (int j = i + 1; j < tempLength; j++) {
                //查找当前范围内重复字符出现的最后位置
                int firstIndex = getFirstIndex(chars, j, tempLength);
                if (firstIndex != tempLength) {
                    tempLength = firstIndex;
                }
            }
            //用最后位置-起始位置=长度
            tempLength = tempLength - i;
            if (maxLength < tempLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }

    /**
     * 查找起始位置和结束位置中 和起始位置相同字符的位置
     *
     * @param data  数据
     * @param start 起始位置
     * @param end   结束位置
     * @return 若查找到返回位置 否则返回结束位置
     */
    private static int getFirstIndex(char[] data, int start, int end) {
        int aChar = data[start];
        for (int i = start + 1; i < end; i++) {
            if (aChar == data[i]) {
                return i;
            }
        }
        return end;
    }


    public static void main(String[] args) {
        System.out.println("无重复字符的最长子串长度为：" + lengthOfLongestSubstring("uqinntq"));
    }

    /**
     * 获取指定长度的字符串
     *
     * @param length 指定长度
     * @return 拼接后的字符串 小写字母a-z
     */
    private static String getRandomString(int length) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (random.nextInt(26) + 97));
        }
        return stringBuilder.toString();
    }

}
