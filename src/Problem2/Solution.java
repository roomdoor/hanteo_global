package Problem2;

public class Solution {

	public static int solution(int[] coins, int sum) {
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int j = coin; j <= sum; j++) {
				dp[j] += dp[j - coin];
			}
		}

		return dp[sum];
	}


	public static void main(String[] args) {
		int[] coins = new int[]{1, 2, 3};
		int sum = 4;
		System.out.println(Solution.solution(coins, sum));

		coins = new int[]{2, 5, 3, 6};
		sum = 10;
		System.out.println(Solution.solution(coins, sum));
	}
}
