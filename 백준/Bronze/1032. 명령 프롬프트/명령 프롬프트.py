import sys

input = sys.stdin.readline


n = int(input())
strings = [input().strip() for _ in range(n)]

curr = ""
for i in range(len(strings[0])):
    isChanged = False
    for stringIndex in range(n):
        string = strings[stringIndex]
        if stringIndex == 0:
            curr = string[i]
        else:
            if curr != string[i]:
                print("?", end="")
                isChanged = True
                break

    if not isChanged:
        print(curr, end="")