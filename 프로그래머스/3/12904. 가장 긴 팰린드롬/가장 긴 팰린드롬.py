def solution(s):
    n = len(s)
    dp = [[-1] * n for _ in range(n)]
    answer = 0

    for i in range(n):
        dp[i][i] = 1
        answer = 1

    for i in range(n - 1):
        if s[i] == s[i + 1]:
            dp[i][i + 1] = 1
            answer = 2

    for length in range(3, n + 1):
        for start in range(n - length + 1):
            end = start + length - 1
            if dp[start + 1][end - 1] == 1 and s[start] == s[end]:
                dp[start][end] = 1
                answer = max(answer, length)

    return answer
