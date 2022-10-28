package problems;

/**
 * SearchRange
 */
public class SearchRange_34 {

    public static void main(String[] args) {
        int[] nums = {5,5,10,11,18,27,52};
        SearchRange_34 result = new SearchRange_34();
        int[] solution = result.searchRange(nums, Integer.parseInt(args[0]));
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] not_found = {-1,-1};
        if(nums.length == 0){
            return not_found;
        }
        int position = binary_search_hub(nums, target);
        if(position == -1){
            return not_found;
        }
        int[] solution = {0,0};
        int leftIndex = position;
        int rightIndex = position;
        while(nums[leftIndex] == target){
            if(leftIndex > 0){
                leftIndex += -1;
            } else{
                leftIndex = -1;
                break;
            }
        }
        while(nums[rightIndex] == target){
            if(rightIndex < nums.length){
                rightIndex += 1;
            } else{
                rightIndex = nums.length;
                break;
            }
        }
        solution[0] = leftIndex+1;
        solution[1] = rightIndex-1;
        return solution;
    }

    public int binary_search_hub(int[] nums, int target){
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        boolean end = false;
        while(!end){
            int middleIndex = (int) (rightIndex-leftIndex)/2+leftIndex;
            if(nums[middleIndex] == target){
                return middleIndex;
            }
            if (leftIndex ==  rightIndex) {
                end = true;
            }
            else if(nums[middleIndex] < target){
                leftIndex = middleIndex+1;
            }else{
                rightIndex = middleIndex -1;
                if (rightIndex < 0) { rightIndex = 0;}
            }
            
        }
        return -1;
    }
}