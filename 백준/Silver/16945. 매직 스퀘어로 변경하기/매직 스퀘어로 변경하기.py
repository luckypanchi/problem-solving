import sys

input = sys.stdin.readline

INF = float("inf")


board = [list(map(int, input().split())) for _ in range(3)]
visited = [False] * 10


def check():
    s = sum(board[0])
    for i in range(3):
        if s != sum(board[i]):
            return False

    for j in range(3):
        result = sum([board[i][j] for i in range(3)])
        if s != result:
            return False

    result = sum([board[i][i] for i in range(3)])
    if s != result:
        return False

    result = sum([board[i][2 - i] for i in range(3)])
    if s != result:
        return False

    return True


def solve(curr, prev):
    if curr == 9:
        if check():
            return prev
        return INF

    result = INF

    y = curr // 3
    x = curr % 3
    original = board[y][x]
    for i in range(1, 10):
        if not visited[i]:
            visited[i] = True
            cost = abs(original - i)
            board[y][x] = i
            result = min(result, solve(curr + 1, prev + cost))
            board[y][x] = original
            visited[i] = False

    return result


print(solve(0, 0))