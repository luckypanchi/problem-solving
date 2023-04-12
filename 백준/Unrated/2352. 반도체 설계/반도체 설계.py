import sys

input = sys.stdin.readline


def binary_search(lis, left, right, target):
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
        num = numbers[i]
        if lis[-1] < num:
            lis.append(num)
            result += 1
        else:
            idx = binary_search(lis, 0, result - 1, num)
            lis[idx] = num

    return result


n = int(input())
numbers = list(map(int, input().split()))

answer = find_lis()

print(answer)