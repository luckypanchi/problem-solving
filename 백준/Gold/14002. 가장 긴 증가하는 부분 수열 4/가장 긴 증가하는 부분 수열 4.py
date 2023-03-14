import sys

input = sys.stdin.readline


n = int(input())
numbers = [0] + list(map(int, input().split()))
dp = [1] * (n + 1)

for i in range(1, n + 1):
    for j in range(1, i):
        if numbers[j] < numbers[i]:
            dp[i] = max(dp[i], dp[j] + 1)

sub = []
m = max(dp)
for i in range(n, 0, -1):
    if dp[i] == m:
        sub.append(numbers[i])
        m -= 1

sub.reverse()
print(max(dp))
print(*sub)