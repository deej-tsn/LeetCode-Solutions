import java.util.ArrayList;
import java.util.List;

/**
 * CountAndSay_38
 */
public class CountAndSay_38 {

    public static void main(String[] args) {
        CountAndSay_38 result = new CountAndSay_38();
        System.out.println(result.countAndSay(4));
        
    }

    public String countAndSay(int n) {
        return countAndSayRecursive(n)+"";
    }

    public long countAndSayRecursive(long n) {
        if(n == 1){
            return 1;
        } else{
            return digitCovert(countAndSayRecursive(n-1));
        }
    }
    public long digitCovert(long n){
        int[] intArray = integerToIntArray(n);
        ArrayList<List<Integer>> pairs = new ArrayList<>();
        int currrentInt = intArray[0];
        int numOfCurrentInt = 0;
        List<Integer> pair = new ArrayList<>();
        for(int i =0; i< intArray.length; i++){
            if(intArray[i] == currrentInt){
                numOfCurrentInt+=1;
            } else{
                pair.add(numOfCurrentInt);
                pair.add(currrentInt);
                pairs.add(pair);
                pair = new ArrayList<>();
                currrentInt = intArray[i];
                numOfCurrentInt = 1;
            }
        }
        pair.add(numOfCurrentInt);
        pair.add(currrentInt);
        pairs.add(pair);
        String num = "";
        for(int i = 0; i< pairs.size(); i++){
            num += pairs.get(i).get(0);
            num += pairs.get(i).get(1);
        }
        return Long.parseLong(num);
    }

    public int[] integerToIntArray(long n){
        String temp = Long.toString(n);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }
}