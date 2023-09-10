import sys

input = sys.stdin.readline


t, w = map(int, input().split())
plums = [0] + [int(input()) for _ in range(t)]

dp = [[0] * (w + 1) for _ in range(t + 1)]

for curr_t in range(t + 1):
    if plums[curr_t] == 1:
        dp[curr_t][0] = dp[curr_t - 1][0] + 1
    else:
        dp[curr_t][0] = dp[curr_t - 1][0]

    for move in range(1, w + 1):
        if move % 2 == 0 and plums[curr_t] == 1:  # 현재위치 1
            dp[curr_t][move] = max(dp[curr_t - 1][move], dp[curr_t - 1][move - 1]) + 1
        elif move % 2 == 1 and plums[curr_t] == 2:
            dp[curr_t][move] = max(dp[curr_t - 1][move], dp[curr_t - 1][move - 1]) + 1
        else:
            dp[curr_t][move] = max(dp[curr_t - 1][move], dp[curr_t - 1][move - 1])

print(max(dp[t]))