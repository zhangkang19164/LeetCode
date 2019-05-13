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
public class Solution2 {
    /**
     * 官方解题方法，研读中
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ret = ret * 10 + pop;
        }
        return ret;
    }


    public static void main(String[] args) {
        int value = -123;
        System.out.println("正常输出：" + value);
        System.out.println("反转后输出：" + reverse(value));
    }
}
