def solution(sticker):
    if len(sticker) < 4:
        return max(sticker)

    answer = -1

    n = len(sticker)
    dp = [0] * n
    dp[0] = sticker[0]
    dp[1] = sticker[0]
    for i in range(2, n - 1):
        dp[i] = max(dp[i - 1], dp[i - 2] + sticker[i])

    answer = max(answer, dp[n - 2])

    dp = [0] * n
    dp[1] = sticker[1]
    for i in range(2, n):
        dp[i] = max(dp[i - 1], dp[i - 2] + sticker[i])

    answer = max(answer, dp[n - 1])

    return answer