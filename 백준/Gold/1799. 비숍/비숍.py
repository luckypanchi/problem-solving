import sys

input = sys.stdin.readline


def dfs(graph, idx, cnt):
    if idx == len(graph):
        return cnt

    results = [0]

    results.append(dfs(graph, idx + 1, cnt))

    for y, x in graph[idx]:
        if board[y][x] == 1 and not diag1[y + x] and not diag2[x - y + n - 1]:
            board[y][x] = 0
            diag1[y + x] = True
            diag2[x - y + n - 1] = True

            results.append(dfs(graph, idx + 1, cnt + 1))

            board[y][x] = 1
            diag1[y + x] = False
            diag2[x - y + n - 1] = False

    return max(results)


n = int(input())
chess = [[(i + j) % 2 == 0 for j in range(n)] for i in range(n)]
board = [list(map(int, input().split())) for _ in range(n)]

white = [[] for _ in range(2 * n - 1)]
black = [[] for _ in range(2 * n - 1)]
for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            if chess[i][j]:
                white[i + j].append((i, j))
            else:
                black[i + j].append((i, j))


diag1 = [False] * (2 * n - 1)
diag2 = [False] * (2 * n - 1)

white_cnt = dfs(white, 0, 0)
black_cnt = dfs(black, 0, 0)


print(white_cnt + black_cnt)