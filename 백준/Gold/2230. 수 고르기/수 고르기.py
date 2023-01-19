import sys

input = sys.stdin.readline
INF = sys.maxsize


n, m = map(int, input().split())
numbers = sorted([int(input()) for _ in range(n)])

left, right = 0, 0

answer = INF
while left < n and right < n:
    diff = numbers[right] - numbers[left]
    if diff == m:
        print(m)
        sys.exit()
    elif diff > m:
        answer = min(answer, diff)
        left += 1
    else:
        right += 1

print(answer)
