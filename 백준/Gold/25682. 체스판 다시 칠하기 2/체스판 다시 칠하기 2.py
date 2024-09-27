import sys

input = sys.stdin.readline

INF = float("inf")


n, m, k = map(int, input().split())
board = [[""] * (m + 1)] + [[""] + list(input().strip()) for _ in range(n)]

prefix_sum1 = [[0] * (m + 1) for _ in range(n + 1)]  # 첫번째 돌이 W
prefix_sum2 = [[0] * (m + 1) for _ in range(n + 1)]  # 첫번째 돌이 B

for i in range(1, n + 1):
    is_white = i % 2 != 0
    for j in range(1, m + 1):
        prefix_sum1[i][j] = prefix_sum1[i - 1][j] + prefix_sum1[i][j - 1] - prefix_sum1[i - 1][j - 1]  # fmt:skip
        prefix_sum2[i][j] = prefix_sum2[i - 1][j] + prefix_sum2[i][j - 1] - prefix_sum2[i - 1][j - 1]  # fmt:skip

        if is_white and board[i][j] == "B":
            prefix_sum1[i][j] += 1
        elif not is_white and board[i][j] == "W":
            prefix_sum1[i][j] += 1

        if is_white and board[i][j] == "W":
            prefix_sum2[i][j] += 1
        elif not is_white and board[i][j] == "B":
            prefix_sum2[i][j] += 1

        is_white = not is_white

answer = INF

for i in range(1, n - k + 2):
    for j in range(1, m - k + 2):
        row_end = i + k - 1
        col_end = j + k - 1
        curr1 = prefix_sum1[row_end][col_end] - prefix_sum1[row_end][j - 1] - prefix_sum1[i - 1][col_end] + prefix_sum1[i - 1][j - 1]  # fmt:skip
        curr2 = prefix_sum2[row_end][col_end] - prefix_sum2[row_end][j - 1] - prefix_sum2[i - 1][col_end] + prefix_sum2[i - 1][j - 1]  # fmt:skip

        answer = min(answer, curr1, curr2)

print(answer)