import sys

input = sys.stdin.readline


n, m = map(int, input().split())
a = [0] + list(map(int, input().split()))
for i in range(1, n + 1):
    a[i] += a[i - 1]

left, right = 0, 1
answer = 0
while right < n + 1 and left < n + 1:
    s = a[right] - a[left]
    if s == m:
        answer += 1
        right += 1
        left += 1
    elif s < m:
        right += 1
    else:
        left += 1

print(answer)