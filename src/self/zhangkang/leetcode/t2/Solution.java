package self.zhangkang.leetcode.t2;

/**
 * Created on 2019/5/7
 * Title: 两数相加
 * Description:
 *
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Android-张康
 * update 2019/5/7
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnListNote = new ListNode(0);
        ListNode temp = returnListNote;
        while (true) {
            //用第一个的值加上第二的值加上进位的值
            int value = l1.val + l2.val + temp.val;
            if (value >= 10) {
                temp.val = value - 10;
                temp.next = new ListNode(1);
            } else {
                temp.val = value;
                temp.next = new ListNode(0);
            }
            if (null == l1.next && null == l2.next) {
                if (temp.next.val == 0) {
                    temp.next = null;
                }
                break;
            }
            temp = temp.next;
            //如果temp1 的下一位为空，说明temp2的位数长
            if (l1.next == null) {
                addOne(temp, l2.next);
                break;
            }
            if (l2.next == null) {
                addOne(temp, l1.next);
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return returnListNote;
    }

    private void addOne(ListNode listNode, ListNode temp1) {
        while (true) {
            int value = listNode.val + temp1.val;
            if (value >= 10) {
                listNode.val = value - 10;
                listNode.next = new ListNode(1);
            } else {
                listNode.val = value;
                listNode.next = new ListNode(0);
            }
            if (temp1.next == null) {
                if (listNode.next.val == 0) {
                    listNode.next = null;
                }
                break;
            }
            listNode = listNode.next;
            temp1 = temp1.next;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = getListNote("5");
        System.out.println(listNode1);
        ListNode listNode2 = getListNote("5");
        System.out.println(listNode2);
        ListNode listNode3 = getListNote(String.valueOf(5 + 5));
        System.out.println(listNode3);
        System.out.println(solution.addTwoNumbers(listNode1, listNode2));
    }

    private static ListNode getListNote(String number) {
        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(number.charAt(number.length() - 1))));
        ListNode temp = listNode;
        for (int i = number.length() - 2; i >= 0; i--) {
            int i1 = Integer.parseInt(String.valueOf(number.charAt(i)));
            temp.next = new ListNode(i1);
            temp = temp.next;
        }
        return listNode;
    }
}
