import sys

input = sys.stdin.readline


def lower_bound(target):
    left, right = 0, n - 1

    while left < right:
        mid = (left + right) // 2
        if array[mid] < target:
            left = mid + 1
        else:
            right = mid

    if array[left] == target:
        return left
    else:
        return -1


n, m = map(int, input().split())
array = sorted([int(input()) for _ in range(n)])
for _ in range(m):
    d = int(input())
    print(lower_bound(d))