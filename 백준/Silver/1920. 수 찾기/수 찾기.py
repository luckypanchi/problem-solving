import sys

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))
m = int(input())
targets = list(map(int, input().split()))


def binary_search(target):
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if numbers[mid] == target:
            return True
        elif numbers[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False


for tgt in targets:
    if binary_search(tgt):
        print(1)
    else:
        print(0)
