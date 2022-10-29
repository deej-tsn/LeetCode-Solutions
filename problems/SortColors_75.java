package problems;

/**
 * SortColors_75
 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] num = {2,0,2,1,1,0,1,2,0};
        SortColors_75 result = new SortColors_75();
        result.SortColors(num);
    }

    public void SortColors(int[] num){
        int numOfZeros = 0;
        int numOfOnes = 0;

        // O(n) algorithm

        // N operatons
        for (int i = 0; i < num.length; i++) {
            switch (num[i]) {
                case 0:
                    numOfZeros +=1;
                    break;
                case 1:
                    numOfOnes+=1;
                    break;
                default:
                    break;
            }
        }
        
        for (int i = 0; i < num.length; i++) {
            if (i < numOfZeros) {
                num[i] = 0;
            }
            else if (i-numOfZeros < numOfOnes) {
                num[i] = 1;
            }else{
                num[i] = 2;
            }
        }
    }
}