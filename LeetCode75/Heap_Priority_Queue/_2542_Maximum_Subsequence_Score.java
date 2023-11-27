package LeetCode75.Heap_Priority_Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * “反悔贪心” 是在处理涉及乘积优化的问题（如 a*b）时。这个思想基于传统的贪心算法，但它允许在后续步骤中对之前作出的贪心选择进行调整。
 *
 * 贪心算法的基本思想:
 * 贪心算法在每一步都做出当前看起来最优的选择，希望这样会导致全局最优解。这种方法在很多问题上都非常高效，
 * 但并不总是能得到最优解。例如，在最大化 a*b 这样的乘积问题中，单纯地选择当前最大的 a 和 b 可能不会导致最大的乘积。
 *
 * 反悔贪心算法：
 * 反悔贪心算法是对传统贪心算法的一种改进。它在实施贪心选择的过程中，保留了回溯并修改之前选择的能力。
 * 这种方法在处理一些特定类型的问题时特别有用，尤其是那些一开始不容易看出所有最优选择的问题。
 *
 * 应用于 a*b 的场景
 * 在尝试最大化 a*b 这样的乘积时，反悔贪心算法可能会这样工作：
 * 1. 初始选择：基于当前信息，选择一对 a 和 b，这在当时看似最优。
 * 2. 后续发现：随着算法的进行，可能发现有另一对值 a' 和 b'，如果之前选择了 a' 而不是 a，那么最终的乘积会更大。
 * 3. 反悔并调整：算法会“反悔”之前的选择，用 a' 替换 a，并重新计算乘积。
 *
 * 示例
 * 以下题目中，需要在 nums1 中选择 k 个元素，并使得这些元素的和与 nums2 中对应元素的最小值的乘积最大。
 * 这里的关键是要平衡 nums1 中元素的和（增大 a）与 nums2 中所选元素的最小值（影响 b）。
 *
 * 在这种情况下，反悔贪心的应用可能涉及到优先选择 nums2 中较大的元素，同时保留对 nums1 中元素选择的灵活性。
 * 如果后来发现通过调整 nums1 中的元素可以获得更大的乘积，算法就可以“反悔”之前的选择。
 *
 * 结论
 * 反悔贪心算法提供了一种动态调整之前决策的方式，使算法能够更灵活地适应问题的特点，尤其适用于那些单步贪心选择无法直接导致最优解的复杂问题。
 * 在多步决策过程中保持一定的灵活性，有助于在整体上找到更优的解决方案。
 */

public class _2542_Maximum_Subsequence_Score {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long res = 0;

        Integer[] sorts = new Integer[n];
        for(int i = 0; i < n; i++) {
            sorts[i] = i;
        }
        Arrays.sort(sorts,(a,b)->nums2[b]-nums2[a]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0; i < k - 1; i++) {
            sum += nums1[sorts[i]];
            priorityQueue.offer(nums1[sorts[i]]);
        }

        for(int i = k - 1; i < n; i++) {
            sum += nums1[sorts[i]];
            priorityQueue.offer(nums1[sorts[i]]);
            res = Math.max(res, nums2[sorts[i]] * sum);
            sum -= priorityQueue.poll();
        }

        return res;
    }
}
