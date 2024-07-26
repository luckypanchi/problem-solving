import sys

input = sys.stdin.readline


x, y = map(int, input().split())

z = (100 * y) // x

if z > 98:
    print(-1)
    sys.exit()

left = 0
right = x
answer = 0
while left <= right:
    mid = (left + right) // 2
    if (100 * (y + mid)) // (x + mid) != z:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)