package self.zhangkang.leetcode.t2;

/**
 * Created on 2019/5/7
 * Title:
 * Description:
 *
 * @author Android-张康
 * update 2019/5/7
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val) + (null == next ? "" : next);
    }
}
