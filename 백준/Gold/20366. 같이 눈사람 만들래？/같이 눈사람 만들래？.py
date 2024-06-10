import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
snowballs = sorted(list(map(int, input().split())))

answer = INF

for start1 in range(n):
    for end1 in range(start1 + 3, n):
        start2 = start1 + 1
        end2 = end1 - 1
        while start2 < end2:
            d = snowballs[start1] + snowballs[end1] - (snowballs[start2] + snowballs[end2])
            answer = min(answer, abs(d))

            if d < 0:
                end2 -= 1
            else:
                start2 += 1

print(answer)