import sys

input = sys.stdin.readline


def solve(matrix, n, x, y, a, b):
    mark = [[0] * (n + 1) for _ in range(n + 1)]
    results = [0] * 6

    for i in range(a + 1):
        mark[x + i][y - i] = 1
        mark[x + b + i][y + b - i] = 1
    for i in range(b + 1):
        mark[x + i][y + i] = 1
        mark[x + a + i][y - a + i] = 1

    for i in range(x + 1, x + a + b):
        flag = False
        for j in range(n):
            if mark[i][j] == 1:
                flag = not flag
            elif mark[i][j] == 0 and flag is True:
                mark[i][j] = 1

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if mark[i][j] == 1:
                results[5] += matrix[i][j]
            else:
                if i < x + a and j <= y:
                    results[1] += matrix[i][j]
                elif i <= x + b and y < j:
                    results[2] += matrix[i][j]
                elif x + a <= i and j < y - a + b:
                    results[3] += matrix[i][j]
                elif x + b < i and y - a + b <= j:
                    results[4] += matrix[i][j]

    return max(results[1:]) - min(results[1:])


def main():
    n = int(input())
    matrix = [[0] * n]
    for _ in range(n):
        matrix.append([0] + list(map(int, input().split())))

    answer = 9999

    for x in range(1, n + 1):
        for y in range(1, n + 1):
            for a in range(1, n + 1):
                for b in range(1, n + 1):
                    if x + a + b < n and 0 <= y - a < y + b < n:
                        answer = min(answer, solve(matrix, n, x, y, a, b))

    print(answer)


main()
