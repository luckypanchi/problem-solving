import sys

input = sys.stdin.readline


n = int(input())
nums = [int(input()) for _ in range(n)]
nums.reverse()

answer = 0
d = 0
p = nums[0]

for i in range(1, n):
    d += 1
    if p - d <= nums[i]:
        answer += nums[i] - (p - d)
    else:
        p = nums[i]
        d = 0

print(answer)