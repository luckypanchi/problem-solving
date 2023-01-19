import sys

input = sys.stdin.readline


def main():
    n = int(input())
    steps = [0]
    for _ in range(n):
        steps.append(int(input()))

    dp = [0] * (n + 1)

    dp[1] = steps[1]

    if n >= 2:
        dp[2] = steps[1] + steps[2]

    if n >= 3:
        dp[3] = max(steps[1] + steps[3], steps[2] + steps[3])
        for i in range(4, n + 1):
            dp[i] = max(dp[i - 2] + steps[i], dp[i - 3] + steps[i - 1] + steps[i])

    print(dp[n])


main()
