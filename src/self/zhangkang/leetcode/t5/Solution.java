package self.zhangkang.leetcode.t5;

/**
 * Created on 2019/5/9
 * Title: 最长的回文子串
 * Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * 示例：
 * 输入："a"
 * 输出："a"
 *
 * @author Android-张康
 * update 2019/5/9
 */
public class Solution {
    /**
     * 暴力解法
     * 时间复杂度O(n3)
     * 空间复杂度 O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        char[] charArray = s.toCharArray();
        for (int i = charArray.length; i > 0; i--) {
            for (int j = 0; j <= charArray.length - i; j++) {
                if (isPalindrome(charArray, j, j + i - 1)) {
                    return new String(charArray, j, i);
                }
            }
        }
        return "";
    }

    /**
     * 判断是范围内的字符是否为回文 包含起始位置和结束位置
     *
     * @param data     数据
     * @param startPos 起始位置
     * @param endPos   结束位置
     * @return 是回文返回true 否则返回false
     */
    private static boolean isPalindrome(char[] data, int startPos, int endPos) {
        if (startPos == endPos) {
            return true;
        }
        while (startPos < endPos) {
            if (data[startPos] != data[endPos]) {
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("最长的回文子串是：" + longestPalindrome("a"));
    }

}
