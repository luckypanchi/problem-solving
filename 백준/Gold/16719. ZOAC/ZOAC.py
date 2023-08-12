import sys

input = sys.stdin.readline

arr = list(input().strip())
result = [""] * len(arr)


def dfs(start, arr):
    if len(arr) == 0:
        return

    _min = min(arr)
    idx = arr.index(_min)

    result[start + idx] = _min
    print("".join(result))

    dfs(start + idx + 1, arr[idx + 1 :])
    dfs(start, arr[:idx])


dfs(0, arr)