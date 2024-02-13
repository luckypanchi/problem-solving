import sys

input = sys.stdin.readline


def check(string):
    length = len(string)

    if length == 1:
        return True

    for i in range(length // 2):
        if int(string[i]) + int(string[length - 1 - i]) != 1:
            return False

    return check(string[: length // 2])


tc = int(input())

for _ in range(tc):
    string = input().strip()
    if check(string):
        print("YES")
    else:
        print("NO")