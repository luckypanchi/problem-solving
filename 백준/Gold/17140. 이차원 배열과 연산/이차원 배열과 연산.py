import sys
from collections import Counter

input = sys.stdin.readline


def main():
    r, c, k = map(int, input().split())
    tmp = [list(map(int, input().split())) for _ in range(3)]
    matrix = [[0] * 100 for _ in range(100)]

    for i in range(3):
        for j in range(3):
            matrix[i][j] = tmp[i][j]

    n, m = 3, 3

    for t in range(101):
        if matrix[r - 1][c - 1] == k:
            print(t)
            return

        candidates = []
        if m <= n:
            for idx in range(n):
                count = Counter(matrix[idx][:m])
                matrix[idx][:m] = [0] * m
                del count[0]
                length = 0
                for a, b in sorted(count.items(), key=lambda x: (x[1], x[0])):
                    if length == 100:
                        break
                    matrix[idx][length] = a
                    matrix[idx][length + 1] = b
                    length += 2
                candidates.append(length)
            m = max(candidates)
        else:
            for idx in range(m):
                tmp = []
                for i in range(n):
                    tmp.append(matrix[i][idx])
                count = Counter(tmp)
                for i in range(n):
                    matrix[i][idx] = 0
                del count[0]
                length = 0
                for a, b in sorted(count.items(), key=lambda x: (x[1], x[0])):
                    if length == 100:
                        break
                    matrix[length][idx] = a
                    matrix[length + 1][idx] = b
                    length += 2
                candidates.append(length)
            n = max(candidates)

    print(-1)


main()
