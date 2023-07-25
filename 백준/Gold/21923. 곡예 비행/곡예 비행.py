import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
board = (
    [[-INF] * (m + 2)]
    + [[-INF] + list(map(int, input().split())) + [-INF] for _ in range(n)]
    + [[-INF] * (m + 2)]
)

up = [[0] * (m + 2) for _ in range(n + 2)]
down = [[0] * (m + 2) for _ in range(n + 2)]

for i in range(n + 2):
    for j in range(m + 2):
        up[i][j] = board[i][j]
        down[i][j] = board[i][j]


def get_max(a, b):
    if a == -INF and b == -INF:
        return 0
    else:
        return max(a, b)


for i in range(n, 0, -1):
    for j in range(1, m + 1):
        up[i][j] += get_max(up[i + 1][j], up[i][j - 1])
        down[i][m - j + 1] += get_max(down[i + 1][m - j + 1], down[i][m - j + 2])


answer = -INF

for i in range(1, n + 1):
    for j in range(1, m + 1):
        answer = max(answer, up[i][j] + down[i][j])

print(answer)