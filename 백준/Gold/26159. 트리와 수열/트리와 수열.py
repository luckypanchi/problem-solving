import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline

MOD = 10**9 + 7


def countDfs(curr, prev):
    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        countDfs(nextNode, curr)
        cnt[curr] += cnt[nextNode]


def dfs(curr, prev):
    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        c = cnt[nextNode] * (n - cnt[nextNode])
        results.append(c)

        dfs(nextNode, curr)


n = int(input())
graph = defaultdict(list)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

weights = sorted(list(map(int, input().split())))

cnt = [1] * (n + 1)
countDfs(1, 0)

results = []
dfs(1, 0)

results.sort(reverse=True)

answer = 0
for i in range(n - 1):
    answer = (answer + weights[i] * results[i]) % MOD

print(answer)