import sys

input = sys.stdin.readline


def dfs(node):
    global answer

    for i in range(n + 1):
        if board[node][i] == 1 and not visited[i]:
            answer += 1
            visited[i] = True
            dfs(i)


n = int(input())
board = [[0] * (n + 1) for _ in range(n + 1)]
m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    board[a][b] = 1
    board[b][a] = 1

visited = [False] * (n + 1)
answer = 0
visited[1] = True
dfs(1)

print(answer)