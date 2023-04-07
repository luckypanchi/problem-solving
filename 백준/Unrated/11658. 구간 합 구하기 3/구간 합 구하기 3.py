import sys

input = sys.stdin.readline


def update(y, x, diff):
    i = y
    while i <= n:
        j = x
        while j <= n:
            tree[i][j] += diff
            j += j & -j
        i += i & -i


def acc_sum(y, x):
    result = 0
    i = y
    while 0 < i:
        j = x
        while 0 < j:
            result += tree[i][j]
            j -= j & -j
        i -= i & -i
    return result


def make_tree():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            update(i, j, board[i][j])


n, m = map(int, input().split())
board = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]

tree = [[0] * (n + 1) for _ in range(n + 1)]

make_tree()

for _ in range(m):
    ops = list(map(int, input().split()))
    if ops[0] == 0:
        y, x, c = ops[1:]
        update(y, x, c - board[y][x])
        board[y][x] = c
    else:
        y1, x1, y2, x2 = ops[1:]
        result = (
            acc_sum(y2, x2)
            - acc_sum(y2, x1 - 1)
            - acc_sum(y1 - 1, x2)
            + acc_sum(y1 - 1, x1 - 1)
        )
        print(result)