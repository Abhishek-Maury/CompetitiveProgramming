package String;

// https://leetcode.com/problems/palindromic-substrings/description/
public class PalindromeSubstrings {
    public static int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for (int i = 0; i < n; i++) {
            int odd = isPalindrome(s, i, i);
            int even =isPalindrome(s, i, i+1);
            ans+=even+odd;
        }
        return ans;
    }

    private static int isPalindrome(String s,int left,int right){
        int count=0;
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(countSubstrings(s));
    }
}

