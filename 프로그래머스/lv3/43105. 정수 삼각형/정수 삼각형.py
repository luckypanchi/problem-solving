def solution(triangle):
    n = len(triangle)
    dp = [[0] * n for _ in range(n)]
    
    dp[0][0] = triangle[0][0]
    
    if 1 < n:
        for level in range(1, n):
            for idx in range(level + 1):
                if 0 <= idx - 1:
                    dp[level][idx] = max(dp[level][idx], dp[level - 1][idx - 1] + triangle[level][idx])
                if idx < level:
                    dp[level][idx] = max(dp[level][idx], dp[level - 1][idx] + triangle[level][idx])

    answer = max(dp[n - 1])
    
    return answer