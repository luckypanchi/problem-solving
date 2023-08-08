import sys

input = sys.stdin.readline


n = int(input())


def dfs(prev, length):
    array = list(str(prev))
    for i in range(1, (length // 2) + 1):
        if array[-i:] == array[-2 * i : -i]:
            return

    if length == n:
        print(prev)
        sys.exit()

    for i in range(1, 4):
        dfs(prev * 10 + i, length + 1)


dfs(0, 0)