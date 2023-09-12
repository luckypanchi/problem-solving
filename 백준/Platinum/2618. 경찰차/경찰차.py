import sys

input = sys.stdin.readline


n = int(input())
w = int(input())
s = [[0, 0]] + [list(map(int, input().split())) for _ in range(w)]
s1 = [[1, 1]] + s[1:]
s2 = [[n, n]] + s[1:]

dp = [[-1] * (w + 1) for _ in range(w + 1)]


def dfs(p1, p2):
    if p1 == w or p2 == w:
        return 0
    if dp[p1][p2] != -1:
        return dp[p1][p2]

    p1_y, p1_x = s1[p1]
    p2_y, p2_x = s2[p2]

    _next = max(p1, p2) + 1
    ny, nx = s[_next]

    d1 = abs(ny - p1_y) + abs(nx - p1_x)
    d2 = abs(ny - p2_y) + abs(nx - p2_x)
    dp[p1][p2] = min(d1 + dfs(_next, p2), d2 + dfs(p1, _next))
    return dp[p1][p2]


def path(p1, p2):
    if p1 == w or p2 == w:
        return

    p1_y, p1_x = s1[p1]
    p2_y, p2_x = s2[p2]

    _next = max(p1, p2) + 1
    ny, nx = s[_next]

    d1 = abs(ny - p1_y) + abs(nx - p1_x)
    d2 = abs(ny - p2_y) + abs(nx - p2_x)

    if d1 + dp[_next][p2] < d2 + dp[p1][_next]:
        print(1)
        path(_next, p2)
    else:
        print(2)
        path(p1, _next)


dfs(0, 0)
print(dp[0][0])
path(0, 0)
