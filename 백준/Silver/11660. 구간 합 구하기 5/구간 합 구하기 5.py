import sys

input = sys.stdin.readline

n, m = map(int, input().split())
matrix = []

for _ in range(n):
    row = list(map(int, input().split()))
    for i in range(1, n):
        row[i] += row[i - 1]
    matrix.append(row)

answers = []

for _ in range(m):
    y1, x1, y2, x2 = map(int, input().split())
    result = 0

    if x1 > 1:
        for y in range(y1 - 1, y2):
            result += matrix[y][x2 - 1] - matrix[y][x1 - 2]
    else:
        for y in range(y1 - 1, y2):
            result += matrix[y][x2 - 1]
    answers.append(result)

for a in answers:
    print(a)
