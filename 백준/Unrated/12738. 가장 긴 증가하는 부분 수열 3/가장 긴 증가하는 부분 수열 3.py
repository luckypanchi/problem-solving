import sys

input = sys.stdin.readline


def lower_bound(lis, left, right, target):
    while left < right:
        mid = (left + right) // 2
        if lis[mid] < target:
            left = mid + 1
        else:
            right = mid
    return right


def find_lis():
    result = 1
    lis = [numbers[0]]

    for i in range(1, n):
        if lis[-1] < numbers[i]:
            lis.append(numbers[i])
            result += 1
        else:
            idx = lower_bound(lis, 0, result - 1, numbers[i])
            lis[idx] = numbers[i]

    return result


n = int(input())
numbers = list(map(int, input().split()))

answer = find_lis()

print(answer)