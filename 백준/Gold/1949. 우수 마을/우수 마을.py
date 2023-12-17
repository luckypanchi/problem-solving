import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(start):
    visited[start] = True

    for i in tree[start]:
        if not visited[i]:
            dfs(i)
            dp[start][0] += max(dp[i][0], dp[i][1])
            dp[start][1] += dp[i][0]


n = int(input())
people = [0] + list(map(int, input().split()))
tree = defaultdict(list)
visited = [False] * (n + 1)

for _ in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

dp = [[0, people[i]] for i in range(n + 1)]
dfs(1)

print(max(dp[1][0], dp[1][1]))