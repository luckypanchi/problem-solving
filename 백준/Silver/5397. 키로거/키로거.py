import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    pwd = list(input().strip())
    left = []
    right = []

    for s in pwd:
        if s == "<" and len(left) != 0:
            right.append(left.pop())
        elif s == ">" and len(right) != 0:
            left.append(right.pop())
        elif s == "-" and len(left) != 0:
            left.pop()
        elif s.isalnum():
            left.append(s)

    answer = "".join(left) + "".join(reversed(right))

    print(answer)