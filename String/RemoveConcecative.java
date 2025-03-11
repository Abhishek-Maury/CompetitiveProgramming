package String;

// https://www.geeksforgeeks.org/problems/consecutive-elements2306/1
public class RemoveConcecative {
    public static String Concecative(String s){
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
       
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i)!=s.charAt(i-1)) {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String s="aabb";
        System.out.println(Concecative(s));
    }
}
