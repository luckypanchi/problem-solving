import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dpDfs(curr, prev):
    dp[curr][isRedBlue[curr]] += 1

    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        dpDfs(nextNode, curr)
        dp[curr][0] += dp[nextNode][0]
        dp[curr][1] += dp[nextNode][1]


def solveDfs(curr, prev):
    blueCount = 0
    redCount = 0

    for nextNode in graph[curr]:
        answers[curr] += dp[nextNode][0] * redCount
        answers[curr] += dp[nextNode][1] * blueCount
        blueCount += dp[nextNode][0]
        redCount += dp[nextNode][1]

    for nextNode in graph[curr]:
        if nextNode == prev:
            continue

        dp[curr][0] -= dp[nextNode][0]  # 루트에 누적된 값에서 현재 값 빼주기
        dp[curr][1] -= dp[nextNode][1]
        dp[nextNode][0] += dp[curr][0]  # 현재 값에 루트에 누적된 값 더하기 -> 현재를 루트로 만들기
        dp[nextNode][1] += dp[curr][1]
        solveDfs(nextNode, curr)
        dp[nextNode][0] -= dp[curr][0]
        dp[nextNode][1] -= dp[curr][1]
        dp[curr][0] += dp[nextNode][0]
        dp[curr][1] += dp[nextNode][1]


n = int(input())
isRedBlue = [-1] + list(map(int, input().split()))  # 1 -> Red / 0 -> Blue
graph = defaultdict(list)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dp = [[0] * 2 for _ in range(n + 1)]
dpDfs(1, 0)

answers = [0] * (n + 1)
solveDfs(1, 0)


q = int(input())
for _ in range(q):
    u = int(input())
    print(answers[u])