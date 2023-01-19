import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
tmp = list(map(int, input().split()))

ops = []

for idx, v in enumerate(tmp):
    for _ in range(v):
        ops.append(idx)

results = []

for orders in set(permutations(ops)):

    result = nums[0]
    for idx in range(len(orders)):
        if orders[idx] == 0:
            result += nums[idx + 1]
        elif orders[idx] == 1:
            result -= nums[idx + 1]
        elif orders[idx] == 2:
            result *= nums[idx + 1]
        elif orders[idx] == 3:
            result /= nums[idx + 1]
            result = int(result)
    results.append(result)

print(max(results))
print(min(results))
