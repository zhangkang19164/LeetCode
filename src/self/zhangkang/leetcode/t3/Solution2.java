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
public class Solution2 {
    /**
     * 思路
     * 大佬的代码 研读中
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int startPos = 0, maxLen = 0, curLen;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            curLen = i - startPos + 1;
            //每向后遍历一个字符就与前面的进行比较
            for (int j = startPos; j < i; j++) {
                //正在比较
                if (chars[i] == chars[j]) {
                    //当前字符 i 有重复的  与 第 索引为 j 的字符重复了
                    curLen--;
                    //将 开始位置挪到 j 后面 那一位的地方
                    startPos = j + 1;
                    break;
                }
            }
            //将最大的 长度变成新的长度
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println("无重复字符的最长子串长度为：" + solution2.lengthOfLongestSubstring("abcabcbb"));
    }


}
