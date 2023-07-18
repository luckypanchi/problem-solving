import sys

input = sys.stdin.readline


dp = [0] * 40
dp[0] = 1
dp[1] = 1


def factorial(num):
    if dp[num] == 0:
        dp[num] = num * factorial(num - 1)

    return dp[num]


def comb(a, b):
    c = max(a, b) - 1
    d = min(a, b)

    return factorial(c + d - 1) // (factorial(c) * factorial(d - 1))


n, m, k = map(int, input().split())

if k == 0:
    answer = comb(n, m)
else:
    k -= 1
    a = k // m + 1
    b = k % m + 1
    answer = comb(a, b) * comb(n - a + 1, m - b + 1)

print(answer)