import sys

input = sys.stdin.readline

while True:
    ipt = input().rstrip()
    if ipt == "":
        break
    else:
        print(ipt)
