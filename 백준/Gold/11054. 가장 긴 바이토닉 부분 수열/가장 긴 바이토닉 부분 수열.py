import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))

dp1 = [0] * n
dp2 = [0] * n

for k in range(n):
    dp1[k] = 1
    for i in range(k):
        if numbers[i] < numbers[k]:
            dp1[k] = max(dp1[k], dp1[i] + 1)

numbers.reverse()

for k in range(n):
    dp2[k] = 1
    for i in range(k):
        if numbers[i] < numbers[k]:
            dp2[k] = max(dp2[k], dp2[i] + 1)

dp2.reverse()

for i in range(n):
    dp1[i] += dp2[i]

print(max(dp1) - 1)