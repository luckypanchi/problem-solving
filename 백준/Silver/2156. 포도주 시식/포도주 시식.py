import sys

input = sys.stdin.readline


def main():
    n = int(input())
    nums = [int(input()) for _ in range(n)]

    dp = [0] * n
    dp[0] = nums[0]

    if n >= 2:
        dp[1] = nums[0] + nums[1]
    if n >= 3:
        dp[2] = max(nums[0] + nums[1], nums[1] + nums[2], nums[2] + nums[0])

    if n >= 4:
        for i in range(3, n):
            dp[i] = max(
                dp[i - 1], dp[i - 3] + nums[i - 1] + nums[i], dp[i - 2] + nums[i]
            )

    print(dp[-1])


main()
