import sys

input = sys.stdin.readline


n, h = map(int, input().split())
heights = list(map(int, input().split()))

heights.sort()

for height in heights:
    if height <= h:
        h += 1
    else:
        break

print(h)
