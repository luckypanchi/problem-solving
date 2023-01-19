import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = list(map(int, input().split()))

left = [0]
right = [0]

for num in numbers:
    if num < 0:
        left.append(-num)
    else:
        right.append(num)

left.sort(reverse=True)
right.sort(reverse=True)

answer = 0

for i in range(len(left)):
    if i % m == 0:
        answer += left[i] * 2

for i in range(len(right)):
    if i % m == 0:
        answer += right[i] * 2

print(answer - max(left[0], right[0]))
