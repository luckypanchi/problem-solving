import sys

input = sys.stdin.readline


def lowerBound(lis, target):
    left, right = 0, len(lis) - 1
    while left < right:
        mid = (left + right) // 2
        if lis[mid] < target:
            left = mid + 1
        else:
            right = mid
    return right


n = int(input())
numbers = list(map(int, input().split()))

lis = [numbers[0]]
for i in range(1, n):
    if lis[-1] < numbers[i]:
        lis.append(numbers[i])
    else:
        index = lowerBound(lis, numbers[i])
        lis[index] = numbers[i]

print(n - len(lis))