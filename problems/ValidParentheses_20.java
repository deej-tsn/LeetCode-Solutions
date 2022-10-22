import java.util.Stack;

/**
 * ValidParentheses_20
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        ValidParentheses_20 result = new ValidParentheses_20();
        System.out.println(result.isValid(args[0]));
    }

    public boolean isValid(String s) {
        final String[] sSplit = s.split("");
        final Stack<String> sStack = new Stack<String>();
        String temp ="";
        for(int i = 0; i < sSplit.length; i++){
            if (sStack.empty()) {
                if (sSplit[i].equals(")") ||
                 sSplit[i].equals("}") ||
                  sSplit[i].equals("]")) {
                    return false;
                } else {
                    sStack.push(sSplit[i]);
                }
            }else{
                temp = sStack.pop();
                switch(sSplit[i]){
                    case ")":
                            if(!temp.equals("(")){
                                return false; 
                            }
                            break;
                    case "}":
                        if(!temp.equals("(")){
                            return false; 
                        }
                        break;
                    case "]":  
                        if(!temp.equals("(")){
                            return false; 
                        }
                        break;
                }
            }
        }
        return sStack.empty();
    }
}

/*
 * 
 * 
 */