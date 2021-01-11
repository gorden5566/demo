//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针


package com.gorden5566.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
         Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        // sort
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // nums[i] > 0
            if (nums[i] > 0) {
                break;
            }

            // filter same val
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // specify left and right
            int left = i + 1;
            int right = length - 1;
            while (left < right) {

                // calculate sum
                int sum = nums[i] + nums[left] + nums[right];

                // find a group
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // filter same val
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // filter same val
                    while ((left < right && nums[right] == nums[right - 1])) {
                        right--;
                    }

                    // point to next val
                    left++;
                    right--;
                }
                // sum is too small
                else if (sum < 0) {
                    left++;
                }
                // sum is too big
                else {
                    right--;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}