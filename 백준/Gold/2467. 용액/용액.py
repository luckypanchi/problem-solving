import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
numbers = list(map(int, input().split()))

diff = INF
left = 0
right = n - 1

answer = []

while left < right:
    curr_v = numbers[left] + numbers[right]

    if abs(curr_v) < diff:
        answer = [numbers[left], numbers[right]]
        diff = abs(curr_v)

    if curr_v == 0:
        break
    elif curr_v < 0:
        left += 1
    else:
        right -= 1

print(*answer)