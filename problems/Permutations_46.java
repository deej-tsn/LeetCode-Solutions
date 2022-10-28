package problems;

import java.util.ArrayList;
import java.util.List;
/**
 * Permutations_46
 */
public class Permutations_46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations_46 result = new Permutations_46();
        List<List<Integer>> solution = result.permute(nums);
        for (List<Integer> list : solution) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        return recursive_permute(numsList, nums.length);
        
    }

    public List<List<Integer>> recursive_permute(List<Integer> numList, int index){
        if(index == 2){
            List<List<Integer>> tempList = new ArrayList<>();
            tempList.add(numList);
            tempList.add(swap(numList, numList.size()-2, numList.size()-1));
            return tempList;
        } else{
            List<List<Integer>> currentList = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                currentList.addAll(recursive_permute(swap(numList, numList.size()-index, numList.size()-index+i), index-1));
            }
            
            return currentList;
        }


    }

    public List<Integer> swap (List<Integer> nums, int index1, int index2){
        List<Integer> new_nums = new ArrayList<>();
        Integer value1 = nums.get(index1);
        Integer value2 = nums.get(index2);
        nums.set(index1, value2);
        nums.set(index2, value1);
        return nums;
        
    }
}