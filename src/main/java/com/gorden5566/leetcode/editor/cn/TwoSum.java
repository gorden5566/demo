// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
// 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
// 输入：nums = [3,2,4], target = 6
// 输出：[1,2]
//
//
// 示例 3：
//
//
// 输入：nums = [3,3], target = 6
// 输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表

package com.gorden5566.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] out = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(out));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();

            for (int index = 0; index < nums.length; index++) {
                int current = nums[index];
                int possible = target - current;
                if (map.containsKey(possible)) {
                    return new int[] {map.get(possible), index};
                }

                map.put(current, index);
            }

            return null;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}