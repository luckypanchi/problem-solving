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
    record = [0] * n
    record[0] = 1

    for i in range(1, n):
        if lis[-1] < numbers[i]:
            lis.append(numbers[i])
            result += 1
            record[i] = result
        else:
            idx = lower_bound(lis, 0, result - 1, numbers[i])
            lis[idx] = numbers[i]
            record[i] = idx + 1

    return result, record


n = int(input())
numbers = list(map(int, input().split()))

length, record = find_lis()

answer = []
prev = length
for i in range(n - 1, -1, -1):
    if record[i] == prev:
        answer.append(numbers[i])
        prev -= 1
    if prev < 1:
        break

print(length)
print(*answer[::-1])


"""
6
8 10 9 9 10 8
(정답: 3/8 9 10)
(오답: 3/8 10 10)
"""