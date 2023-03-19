import sys

input = sys.stdin.readline


n, m = map(int, input().split())


def solve(prev, p, length):
    if length == m:
        print(*prev)
        return

    for i in range(p, n + 1):
        solve(prev + [i], i, length + 1)


solve([], 1, 0)