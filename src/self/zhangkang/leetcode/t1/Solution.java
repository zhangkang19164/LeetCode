package self.zhangkang.leetcode.t1;

/**
 * Created on 2019/5/7
 * Title:  两数之和
 * Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Android-张康
 * update 2019/5/7
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if(null==nums||nums.length<2){
            return new int[0];
        }
        int[] returnData=new int[2];
        int length=nums.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]+nums[j]==target){
                    returnData[0]=i;
                    returnData[1]=j;
                    return returnData;
                }
            }
        }
        return new int[0];
    }
}
