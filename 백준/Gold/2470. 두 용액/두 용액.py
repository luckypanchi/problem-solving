import sys

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))

start = 0
end = n - 1

result = float("INF")
answer = []

while start < end:
    total = numbers[start] + numbers[end]
    if abs(total) < result:
        result = abs(total)
        answer = [numbers[start], numbers[end]]

    if total == 0:
        break
    elif total < 0:
        start += 1
    else:
        end -= 1

print(*answer)
