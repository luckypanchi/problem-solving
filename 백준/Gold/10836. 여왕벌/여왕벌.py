import sys

input = sys.stdin.readline


m, n = map(int, input().split())
larva = [1] * (2 * m + 1)

for _ in range(n):
    a, b, c = map(int, input().split())

    for i in range(a, a + b):
        larva[i] += 1

    for i in range(a + b, a + b + c):
        larva[i] += 2

for i in range(m):
    for j in range(m):
        if j == 0:
            print(larva[m - (i + 1)], end=" ")
        else:
            print(larva[m + j - 1], end=" ")
    print()