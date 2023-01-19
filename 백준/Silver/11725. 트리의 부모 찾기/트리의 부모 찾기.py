import sys

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


n = int(input())
matrix = [[] * (n + 1) for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    matrix[b].append(a)
    matrix[a].append(b)

answer = [0] * (n + 1)


def dfs(num):
    for i in matrix[num]:
        if answer[i] == 0:
            answer[i] = num
            dfs(i)


dfs(1)
for i in range(2, n + 1):
    print(answer[i])
