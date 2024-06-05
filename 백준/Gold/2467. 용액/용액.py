import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
numbers = sorted(list(map(int, input().split())))

diff = INF
start = 0
end = n - 1

answer = []

while start < end:
    s = numbers[start] + numbers[end]

    if abs(s) < diff:
        answer = [numbers[start], numbers[end]]
        diff = abs(s)

    if s == 0:
        break
    elif s < 0:
        start += 1
    else:
        end -= 1

print(*answer)