import sys

input = sys.stdin.readline


def solve(graph, curr, count):
    if curr == len(graph):
        return count

    result = 0
    result = max(result, solve(graph, curr + 1, count))

    for y, x in graph[curr]:
        if not daegakCheck1[y + x] and not daegakCheck2[n - 1 + x - y]:
            daegakCheck1[y + x] = True
            daegakCheck2[n - 1 + x - y] = True

            result = max(result, solve(graph, curr + 1, count + 1))

            daegakCheck1[y + x] = False
            daegakCheck2[n - 1 + x - y] = False

    return result


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

white = [[] for _ in range(2 * n - 1)]
black = [[] for _ in range(2 * n - 1)]
for i in range(n):
    isWhite = i % 2 == 0
    for j in range(n):
        if board[i][j] == 1:
            if isWhite:
                white[i + j].append((i, j))
            else:
                black[i + j].append((i, j))
        isWhite = not isWhite


daegakCheck1 = [False] * (2 * n - 1)
daegakCheck2 = [False] * (2 * n - 1)

whiteCount = solve(white, 0, 0)
blackCount = solve(black, 0, 0)


print(whiteCount + blackCount)