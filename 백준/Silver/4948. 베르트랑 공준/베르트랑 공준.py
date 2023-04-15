import sys

input = sys.stdin.readline


def prime_list(n):
    sieve = [True] * (n + 1)

    m = int(n**0.5)
    for i in range(2, m + 1):
        if sieve[i] is True:
            for j in range(i + i, n + 1, i):
                sieve[j] = False

    return sieve


N = 123456

flags = prime_list(2 * N)

dp = [0] * (2 * N + 1)
for i in range(2, 2 * N + 1):
    if flags[i]:
        dp[i] = dp[i - 1] + 1
    else:
        dp[i] = dp[i - 1]


answers = []
while True:
    n = int(input())

    if n == 0:
        break

    print(dp[2 * n] - dp[n])