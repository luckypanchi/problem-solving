import sys

input = sys.stdin.readline

INF = int(1e9)


def tsp(now, visited):
    if visited == END:
        if cost[now][0] != 0:
            return cost[now][0]
        else:
            return INF

    if dp[now][visited] != 0:
        return dp[now][visited]

    dp[now][visited] = INF

    for i in range(n):
        if cost[now][i] == 0:
            continue

        if visited & (1 << i) != 0:
            continue

        tmp = tsp(i, visited | (1 << i))
        dp[now][visited] = min(dp[now][visited], cost[now][i] + tmp)

    return dp[now][visited]


n = int(input())
p = [list(map(int, input().split())) for _ in range(n)]
cost = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        d = (p[i][0] - p[j][0]) ** 2 + (p[i][1] - p[j][1]) ** 2
        cost[i][j] = d ** (1 / 2)

END = (1 << n) - 1
dp = [[0] * (1 << n) for _ in range(n)]

print(tsp(0, 1))