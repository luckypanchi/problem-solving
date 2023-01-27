import sys

input = sys.stdin.readline


n = input().strip()

zero_counts = 0
one_counts = 0

current = ""

for num in n:
    if current != num:
        current = num
        if num == "0":
            zero_counts += 1
        elif num == "1":
            one_counts += 1

print(min(zero_counts, one_counts))