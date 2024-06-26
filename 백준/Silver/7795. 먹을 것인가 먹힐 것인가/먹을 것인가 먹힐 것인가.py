import sys

input = sys.stdin.readline


def find(target):
    left = 0
    right = len(b) - 1
    while left <= right:
        mid = (left + right) // 2
        if b[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return left


tc = int(input())
for _ in range(tc):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = sorted(list(map(int, input().split())))

    answer = 0
    for target in a:
        answer += find(target)

    print(answer)