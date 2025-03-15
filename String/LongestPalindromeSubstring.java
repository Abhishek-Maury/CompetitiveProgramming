package String;

public class LongestPalindromeSubstring {

    public static String longestPalindrome(String s) {
        if (s.length()<=1) {
            return s;
        }
        String maxStr=s.substring(0, 1);
        for (int i = 0; i < s.length()-1; i++) {
            String odd = expendFromCenter(s, i, i);
            String even = expendFromCenter(s, i, i+1);
            
            if (odd.length()>maxStr.length()) {
                maxStr=odd;
            }
            if (even.length()>maxStr.length()) {
                maxStr=even;
            }
        }
        return maxStr;
    }

    private static String expendFromCenter(String s,int left ,int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
    public static void main(String[] args) {
        String s="cbbd";
        System.out.println(longestPalindrome(s));
    }
}
