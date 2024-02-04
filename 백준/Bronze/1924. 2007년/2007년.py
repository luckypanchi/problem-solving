import sys

input = sys.stdin.readline


x, y = map(int, input().split())

totalDays = y
weekdays = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]

for m in range(1, x):
    if m in {1, 3, 5, 7, 8, 10, 12}:
        totalDays += 31
    elif m in {4, 6, 9, 11}:
        totalDays += 30
    elif m == 2:
        totalDays += 28

print(weekdays[totalDays % 7])