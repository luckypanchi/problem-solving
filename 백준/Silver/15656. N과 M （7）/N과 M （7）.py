import sys

input = sys.stdin.readline


def solve(idx):
    if idx == m:
        print(*selected)
        return

    for i in range(n):
        selected[idx] = numbers[i]
        solve(idx + 1)


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

selected = [0] * m

solve(0)