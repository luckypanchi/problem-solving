MOD = 1000000007


def solution(n, money):
    dp = [0] * (n + 1)
    dp[0] = 1

    for change in money:
        for target in range(change, n + 1):
            dp[target] += dp[target - change]
            dp[target] %= MOD

    return dp[n]
