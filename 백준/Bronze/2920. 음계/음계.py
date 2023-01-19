import sys

input = sys.stdin.readline


array = list(map(int, input().split()))

answer1 = 0
answer2 = 0


for i in range(7):
    if array[i] < array[i + 1]:
        answer1 += 1
    elif array[i] > array[i + 1]:
        answer2 += 1

if answer1 == 7:
    print("ascending")
elif answer2 == 7:
    print("descending")
else:
    print("mixed")
