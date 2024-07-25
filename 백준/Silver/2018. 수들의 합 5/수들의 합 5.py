import sys

input = sys.stdin.readline


n = int(input())

left = 0
right = 1
s = 0
answer = 0
while left <= n:
    if s <= n:
        if s == n:
            answer += 1
        s += right
        right += 1
    elif n < s:
        s -= left
        left += 1

print(answer)