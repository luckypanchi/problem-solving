import sys

input = sys.stdin.readline


def dfs(idx, prev):
    if idx == n:
        for num in prev[1:]:
            print(num)
        sys.exit()

    for num in numbers[idx]:
        if num != prev[-1] and not visited[idx][num]:
            visited[idx][num] = True
            dfs(idx + 1, prev + [num])


n = int(input())
numbers = [list(map(int, input().split()))[1:] for _ in range(n)]

visited = [[False] * 10 for _ in range(n)]

dfs(0, [-1])

print(-1)