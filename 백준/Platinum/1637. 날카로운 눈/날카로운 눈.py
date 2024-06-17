import sys

input = sys.stdin.readline


def count(target):
    result = 0
    for a, c, b in numbers:
        m = min(target, c)
        if a <= m:
            result += (m - a) // b + 1
    return result


n = int(input())
numbers = [list(map(int, input().split())) for _ in range(n)]

left = 1
right = 2147483647
answer = -1

while left <= right:
    mid = (left + right) // 2

    if count(mid) % 2 == 0:
        left = mid + 1
    else:
        answer = mid
        right = mid - 1

if answer == -1:
    print("NOTHING")
else:
    print(answer, count(answer) - count(answer - 1))