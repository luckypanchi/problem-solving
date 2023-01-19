import sys

input = sys.stdin.readline


tc = int(input())

for t in range(1, tc + 1):
    print(f"Class {t}")

    nums = list(map(int, input().split()))
    n = nums[0]
    nums = sorted(nums[1:])
    gap = -1
    for i in range(len(nums) - 1):
        g = nums[i + 1] - nums[i]
        if gap < g:
            gap = g
    print(f"Max {nums[-1]}, Min {nums[0]}, Largest gap {gap}")
