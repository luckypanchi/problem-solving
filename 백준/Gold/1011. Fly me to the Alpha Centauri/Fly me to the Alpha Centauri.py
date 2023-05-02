import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    a, b = map(int, input().split())
    d = b - a

    cnt = 0
    m = 1
    moves = 0

    while moves < d:
        cnt += 1
        moves += m
        if cnt % 2 == 0:
            m += 1

    print(cnt)