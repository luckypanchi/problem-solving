import sys

input = sys.stdin.readline


n, m = map(int, input().split())


def count(target, number):
    cnt = 0
    while target != 0:
        target = target // number
        cnt += target
    return cnt


two_cnt = count(n, 2) - count(n - m, 2) - count(m, 2)
five_cnt = count(n, 5) - count(n - m, 5) - count(m, 5)

print(min(two_cnt, five_cnt))