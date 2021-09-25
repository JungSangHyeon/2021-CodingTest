package year_2021.month_09.day_25;

import java.util.Stack;

public class P175_°ýÈ£º¯È¯ {

    public String solution(String p) {
        return fun(p);
    }

    public String fun(String s){
        //1
        if(s.equals("")) return "";

        // 2
        String u="", v="";
        int leftCount = 0, rightCount = 0, i = 0;
        while((leftCount==0 && rightCount==0) || leftCount!=rightCount){
            char c = s.charAt(i++);
            switch(c){
                case '(': leftCount++; break;
                case ')': rightCount++; break;
            }
            u+=c;
        }
        v=s.substring(i);

        if(isCorrect(u)){
            // 3
            return u + fun(v);
        }else{
            // 4
            String u2 = "";
            for(int j=1; j<u.length()-1; j++){
                switch(u.charAt(j)){
                    case '(': u2+=')'; break;
                    case ')': u2+='('; break;
                }
            }
            return "("+fun(v)+")"+u2;
        }
    }

    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        stack.push('X');
        for(char c : s.toCharArray()){
            char before = stack.peek();
            if(before=='(' && c==')'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size()==1;
    }

}
