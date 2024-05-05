import sys

input = sys.stdin.readline


def solve(prev):
    global count
    s = sum(prev)
    if s == n:
        count += 1
        if count == k:
            print("+".join(map(str, prev)))
            sys.exit()
        return

    for num in [1, 2, 3]:
        if s + num <= n:
            solve(prev + [num])


n, k = map(int, input().split())

count = 0

solve([])

print(-1)