import sys

input = sys.stdin.readline


n, m, k = map(int, input().split())
matrix = [[0] * m for _ in range(n)]
stickers = []
for _ in range(k):
    a, b = map(int, input().split())
    stickers.append([list(map(int, input().split())) for _ in range(a)])


def rotate(arr):
    n = len(arr)
    m = len(arr[0])
    rotated = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            rotated[i][j] = arr[n - j - 1][i]
    return rotated


def check(y, x, a, b, sticker):
    if not (y + a - 1 < n and x + b - 1 < m):
        return False

    for i in range(a):
        for j in range(b):
            if matrix[y + i][x + j] == 1 and sticker[i][j] == 1:
                return False

    return True


def solve(sticker, cnt):
    if cnt == 4:
        return

    a = len(sticker)
    b = len(sticker[0])

    for y in range(n):
        for x in range(m):
            if check(y, x, a, b, sticker):
                for i in range(a):
                    for j in range(b):
                        matrix[y + i][x + j] += sticker[i][j]
                return

    sticker = rotate(sticker)
    return solve(sticker, cnt + 1)


for sticker in stickers:
    solve(sticker, 0)

answer = 0

for i in range(n):
    for j in range(m):
        answer += matrix[i][j]

print(answer)
