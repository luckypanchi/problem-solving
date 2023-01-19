import sys

input = sys.stdin.readline


def main():
    n = int(input())
    dp = [0] * (n + 1)

    dp[1] = 1

    if n == 1:
        print(dp[1])

    elif n >= 2:
        dp[2] = 3

        if n == 2:
            print(dp[2])
        else:
            for i in range(3, n + 1):
                dp[i] = dp[i - 1] + dp[i - 2] * 2
            print(dp[n] % 10007)


main()
