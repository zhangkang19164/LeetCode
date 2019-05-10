package self.zhangkang.leetcode.t6;

import java.util.ArrayList;

/**
 * Created on 2019/5/10
 * Title:   Z 字形变换
 * Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * LE
 * ET
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 示例3
 * <p>16
 * 输入: s = "LEETCODEISHIRING", numRows = 5
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L      I
 * E    E S   G
 * E   D  H  N
 * T O    I I
 * C      R
 * <p>
 * LI
 * EESG
 * EDHN
 * TOII
 * CR
 *
 * @author Android-张康
 * update 2019/5/10
 */
public class Solution {

    /**
     * @param s       字符串
     * @param numRows 给定的行数
     * @return Z 字形变换后的字符串
     */
    public static String convert(String s, int numRows) {
        if (null == s || numRows < 2 || s.length() <= numRows) {
            return s;
        }
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arrayList.add(new StringBuilder());
        }
        int cur = 0;
        boolean goingDown = false;
        for (char aChar : s.toCharArray()) {
            arrayList.get(cur).append(aChar);
            if (cur == 0 || cur == numRows - 1) {
                goingDown = !goingDown;
            }
            cur += goingDown ? 1 : -1;
        }
        for (int i = 1; i < numRows; i++) {
            arrayList.get(0).append(arrayList.get(i));
        }
        return arrayList.get(0).toString();
    }

    public static void main(String[] args) {
        System.out.println("Z 字形变换前：LEETCODEISHIRING");
        System.out.println("Z 字形变换后：LCIRETOESIIGEDHN");
        System.out.println("Z 字形变换后：" + convert("LEETCODEISHIRING", 3));
    }
}
