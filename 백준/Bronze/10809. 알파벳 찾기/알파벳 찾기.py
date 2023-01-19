import sys

input = sys.stdin.readline

string = input()

answer = [-1] * 26
alphabet = "abcdefghijklmnopqrstuvwxyz"

for i, c in enumerate(alphabet):
    if c in string:
        answer[i] = string.index(c)

print(*answer)
