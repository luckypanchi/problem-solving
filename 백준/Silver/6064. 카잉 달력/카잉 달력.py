import sys

input = sys.stdin.readline


def check(m, n, x, y):
    while x <= m * n:
        if (x - y) % n == 0:
            return x
        x += m
    return -1


tc = int(input())

for _ in range(tc):
    m, n, x, y = map(int, input().split())

    answer = check(m, n, x, y)
    print(answer)