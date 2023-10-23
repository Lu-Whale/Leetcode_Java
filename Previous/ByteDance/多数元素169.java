package Previous.ByteDance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 多数元素169 {

    class SolutionSort {
        public int majorityElement(int[] nums) {
//            Arrays.sort(nums);
//            int result = nums[0];
//            int count = 1;
//            for(int i = 1; i < nums.length; i++) {
//                if(count > nums.length / 2) {
//                    break;
//                }
//                if(nums[i] == result) {
//                    count++;
//                }else {
//                    result = nums[i];
//                    count = 1;
//                }
//            }
//
//            return result;

            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }

    class Solution {
        //使用map存储每个数作为key，每个数出现的次数作为value
        private Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<>();
            for(int num : nums) {
                if(!counts.containsKey(num)) {
                    counts.put(num, 1);
                }else {
                    counts.put(num, counts.get(num) +1);
                }
            }
            return counts;
        }

        public int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = countNums(nums);

            //初始化结果键值对，遍历所有键值对找到value最大的，返回key
            Map.Entry<Integer, Integer> result = null;
            //counts.entrySet() 是 Java 中用于获取一个 Map（例如，HashMap 或 TreeMap）中键值对（Entry 对象）的集合。
            //这个方法返回一个 Set<Entry<K, V>>，其中 K 表示键的类型，V 表示值的类型。
            for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if(result == null || entry.getValue() > result.getValue()) {
                    result = entry;
                }
            }

            return result.getKey();
        }
    }

}













