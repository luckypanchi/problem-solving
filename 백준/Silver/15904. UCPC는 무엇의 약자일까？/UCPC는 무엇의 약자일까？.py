import sys

input = sys.stdin.readline


string = input().strip()
ucpc = "UCPC"
idx = 0

for s in string:
    if s == ucpc[idx]:
        idx += 1
    if idx == 4:
        print("I love UCPC")
        sys.exit()

print("I hate UCPC")
