package self.zhangkang.leetcode.t3;

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
public class Solution3 {
    /**
     * 思路
     * 滑动窗口
     * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
     * 即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j)
     * 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //先判断是否为空，如果为空返回0
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        //开始的位置
        int startPos = 0;
        //从第0位开始向后循环，每次和前面的部分依此比较，如果有相同的
        //字符，将开始坐标移动到该字符的后一位
        for (int i = 0; i < charArray.length; i++) {
            for (int j = startPos; j < i; j++) {
                if (charArray[i] == charArray[j]) {
                    startPos = j + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, i - startPos + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println("无重复字符的最长子串长度为：" + lengthOfLongestSubstring("abcabcbb"));
    }


}
