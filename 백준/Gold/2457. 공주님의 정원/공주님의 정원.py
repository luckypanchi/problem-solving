import sys

input = sys.stdin.readline


n = int(input())
dates = []

for _ in range(n):
    a, b, c, d = map(int, input().split())
    dates.append([100 * a + b, 100 * c + d])

dates.sort()

answer = 0
end = 0
end_date = 301

while dates:
    if 1201 <= end_date or end_date < dates[0][0]:
        break

    for _ in range(len(dates)):
        if dates[0][0] <= end_date:
            end = max(end, dates[0][1])
            dates.remove(dates[0])
        else:
            break

    end_date = end
    answer += 1

if end_date < 1201:
    print(0)
else:
    print(answer)