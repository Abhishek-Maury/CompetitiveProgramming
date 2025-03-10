package String;

public class ValidPalindrome {
    public static boolean palindrome(String str){
       str= str.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (str.isEmpty()) {
            return true;
        }        
        int i=0;
        int j=str.length()-1;
        while (i<j) {
            if (str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    
    }
    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        if (palindrome(str)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

