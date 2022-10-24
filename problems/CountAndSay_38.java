package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * CountAndSay_38
 */
public class CountAndSay_38 {

    public static void main(String[] args) {
        CountAndSay_38 result = new CountAndSay_38();
        System.out.println(result.countAndSay(20));
        
    }

    public String countAndSay(int n) {
        return countAndSayRecursive(n+"");
    }

    public String countAndSayRecursive(String n) {
        if(n.equals("1")){
            return "1";
        } else{
            int tempN = Integer.parseInt(n)-1;
            return digitCovertString(countAndSayRecursive(tempN+""));
        }
    }

    public String digitCovertString(String n){
        String num = "";
        String[] intArray = n.split("");
        String currentInt = intArray[0];
        Integer numOfCurrentInt = 0;
        for(int i =0; i< intArray.length; i++){
            if(intArray[i].equals(currentInt)){
                numOfCurrentInt+=1;
            } else{
                num += numOfCurrentInt;
                num += currentInt;
                currentInt = intArray[i];
                numOfCurrentInt = 1;
            }
        }
        num += numOfCurrentInt;
        num += currentInt;
        return num;
    }
}