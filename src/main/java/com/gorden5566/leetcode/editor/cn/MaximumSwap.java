//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学


package com.gorden5566.leetcode.editor.cn;
public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(98368));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        int digits = digits(num);
        if (digits < 2) {
            return num;
        }

        int[] arr = parse(num, digits);

        boolean changed = false;
        for (int i = digits - 1; i > 0; i--) {
            int index = findMaxThanTarget(arr, 0, i - 1, arr[i]);

            if (index < 0) {
                continue;
            }

            swap(arr, i, index);
            changed = true;
            break;
        }

        return changed ? convert(arr) : num;
    }

        private int digits(int num) {
            int digit = 0;
            while (num != 0) {
                num /= 10;
                digit++;
            }
            return digit;
        }

        private int[] parse(int num, int digits) {
            int[] arr = new int[digits];
            for (int i = 0; i < digits; i++) {
                arr[i] = num % 10;
                num = num / 10;
            }
            return arr;
        }

        private int convert(int[] arr) {
            int length = arr.length;
            int result = 0;
            for (int i = length - 1; i >= 0; i--) {
                result = result * 10 + arr[i];
            }
            return result;
        }

        private int findMaxThanTarget(int[] arr, int left, int right, int target) {
            int index = left;
            int max = arr[left];
            for (int i = left + 1; i <= right; i++) {
                if (arr[i] > max) {
                    index = i;
                    max = arr[i];
                }
            }
            return max > target ? index : -1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}