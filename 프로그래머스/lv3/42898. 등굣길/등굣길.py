def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    flag = [[True] * (m + 1) for _ in range(n + 1)]
    
    for x, y in puddles:
        flag[y][x] = False
        
    for y in range(1, n + 1):
        for x in range(1, m + 1):
            if y == 1 and x == 1:
                dp[y][x] = 1
            elif flag[y][x]:
                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % 1000000007
            
    answer = dp[n][m]
    return answer