package String;

public class CountPAlindromeSubsequence {

    public static int countPsUtil(String s, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1 + countPsUtil(s, i + 1, j, dp) + countPsUtil(s, i, j - 1, dp);
        } else {
            dp[i][j] = countPsUtil(s, i + 1, j, dp) +
                    countPsUtil(s, i, j - 1, dp) -
                    countPsUtil(s, i + 1, j - 1, dp);
        }
        return dp[i][j];
    }

    public static int countPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return countPsUtil(s, 0, n-1, dp);

    }

    public static void main(String[] args) {
       String s="abca";
       System.out.println(countPS(s));
    }
}
