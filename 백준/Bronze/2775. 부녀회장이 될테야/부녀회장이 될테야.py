import sys

input = sys.stdin.readline


apartment = [list(range(1, 16))] + [[1] + [0] * 15 for _ in range(15)]

for i in range(1, 16):
    for j in range(1, 16):
        apartment[i][j] += sum(apartment[i - 1][: j + 1])

tc = int(input())

for _ in range(tc):
    k = int(input())
    n = int(input())
    print(apartment[k][n - 1])
