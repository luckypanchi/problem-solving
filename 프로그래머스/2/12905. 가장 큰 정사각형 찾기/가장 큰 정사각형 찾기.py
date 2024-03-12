def solution(board):
    n = len(board)
    m = len(board[0])

    dp = [[0] * (m + 1) for _ in range(n + 1)]
    answer = 0

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if board[i - 1][j - 1] == 0:
                continue

            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
            answer = max(answer, dp[i][j])

    return answer * answer