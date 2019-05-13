package self.zhangkang.leetcode.t7;

/**
 * Created on 2019/5/13
 * Title: 整数反转
 * Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author Android-张康
 * update 2019/5/13
 */
public class Solution {
    /**
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //先将数字转为字符
        String number = String.valueOf(x);
        //获取字符的长度
        int length = number.length();
        char[] data = new char[length];
        if (x < 0) {
            data[0] = '-';
            for (int i = 1; i < length; i++) {
                data[i] = number.charAt(length - i);
            }
        } else {
            for (int i = 0; i < length; i++) {
                data[i] = number.charAt(length - i - 1);
            }
        }
        number = new String(data);
        long l = Long.parseLong(number);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) l;

    }


    public static void main(String[] args) {
        int value = -100;
        System.out.println("正常输出：" + value);
        System.out.println("反转后输出：" + reverse(value));
    }
}
