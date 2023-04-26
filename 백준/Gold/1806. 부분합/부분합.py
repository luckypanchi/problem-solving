import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
numbers = list(map(int, input().split()))

left, right = 0, 0
s = 0
answer = INF

while True:
    if s < m and right < n:
        s += numbers[right]
        right += 1
    elif m <= s:
        answer = min(answer, right - left)
        s -= numbers[left]
        left += 1
    else:
        break


if answer == INF:
    answer = 0

print(answer)