import sys

input = sys.stdin.readline

n = int(input())
liq = sorted(list(map(int, input().split())))

total = float("INF")
answer = []

for i in range(n - 2):
    start = i + 1
    end = n - 1
    while start < end:
        result = liq[i] + liq[start] + liq[end]

        if abs(result) < abs(total):
            total = result
            answer = [liq[i], liq[start], liq[end]]

        if result < 0:
            start += 1
        elif result > 0:
            end -= 1
        else:
            print(*answer)
            sys.exit()

print(*answer)
