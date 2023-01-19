import sys

input = sys.stdin.readline


points = [int(input()) for _ in range(8)]
sorted_points = sorted(points, reverse=True)
p = 0
nums = []
for i in range(5):
    p += sorted_points[i]
    nums.append(points.index(sorted_points[i]))

nums.sort()

print(p)
for i in range(5):
    print(nums[i] + 1, end=" ")
