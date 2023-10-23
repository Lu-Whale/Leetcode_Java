package Previous.ByteDance;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素215 {


//    public int findKthLargest2(int[] nums, int k) {
//        int target = nums.length - k;
//
//        int left = 0;
//        int right = nums.length -1;
//
//        while (left <= right) {
//            int pivotIndex = partition()
//        }
//    }


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }

    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            if(queue.size() < k) {
                queue.add(nums[i]);
            }else {
                if(nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    // 方法一：基于快速排序的选择方法
    int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];

        int x = nums[left], leftPointer = left - 1, rightPointer = right + 1;

        while (leftPointer < rightPointer) {
            do leftPointer++; while (nums[leftPointer] < x);
            do rightPointer--; while (nums[rightPointer] > x);
            if (leftPointer < rightPointer){
                int tmp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = tmp;
            }
        }
        if (k <= rightPointer) return quickselect(nums, left, rightPointer, k);
        else return quickselect(nums, rightPointer + 1, right, k);
    }
    public int findKthLargestQuickSort(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }



}
