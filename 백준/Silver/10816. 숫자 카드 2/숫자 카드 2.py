import sys

input = sys.stdin.readline


n = int(input())
cards = sorted(list(map(int, input().split())))
m = int(input())
targets = list(map(int, input().split()))


def lowerBound(target):
    left = 0
    right = n

    while left < right:
        mid = (left + right) // 2
        if cards[mid] < target:
            left = mid + 1
        else:
            right = mid

    return left


def uppperBound(target):
    left = 0
    right = n

    while left < right:
        mid = (left + right) // 2
        if target < cards[mid]:
            right = mid
        else:
            left = mid + 1

    return left


for target in targets:
    lower = lowerBound(target)
    upper = uppperBound(target)

    print(upper - lower, end=" ")