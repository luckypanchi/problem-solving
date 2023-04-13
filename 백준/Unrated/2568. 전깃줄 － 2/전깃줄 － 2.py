import sys
from collections import defaultdict

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

    return (result, record)


n = int(input())
pairs = [list(map(int, input().split())) for _ in range(n)]

numbers = [p[1] for p in sorted(pairs, key=lambda x: x[0])]

length, record = find_lis()
lis = []
prev = length
for i in range(n - 1, -1, -1):
    if record[i] == prev:
        lis.append(numbers[i])
        prev -= 1
    if prev == 0:
        break

reversing = defaultdict(int)
for i in range(n):
    reversing[pairs[i][1]] = pairs[i][0]

for i in lis:
    reversing[i] = -1

answer = []
for key in reversing:
    if reversing[key] != -1:
        answer.append(reversing[key])

answer.sort()

print(len(answer))
for ans in answer:
    print(ans)