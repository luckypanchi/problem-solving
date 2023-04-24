import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

selected = [0] * m


def comb(start, cnt):
    if cnt == m:
        print(*selected)
        return

    for i in range(start, n):
        selected[cnt] = numbers[i]
        comb(i, cnt + 1)


comb(0, 0)