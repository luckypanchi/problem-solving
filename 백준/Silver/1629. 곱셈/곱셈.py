import sys

input = sys.stdin.readline


a, b, c = map(int, input().split())


def go(cnt):
    if cnt == 1:
        return a % c

    res = go(cnt // 2)
    if cnt % 2 == 0:
        return res * res % c
    else:
        return res * res * a % c


print(go(b) % c)
