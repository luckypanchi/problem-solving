import sys

input = sys.stdin.readline


while True:
    given = input().rstrip()
    if given == "":
        break

    s, t = given.split()
    idx = 0
    for letter in t:
        if letter == s[idx]:
            idx += 1
            if idx == len(s):
                print("Yes")
                break
    else:
        print("No")
