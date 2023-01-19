import sys
import re

input = sys.stdin.readline


n = int(input())
p = re.compile("^([A-F]{0,1})(A+)(F+)(C+)([A-F]{0,1})$")
for _ in range(n):
    string = input().rstrip()
    if p.match(string):
        print("Infected!")
    else:
        print("Good")
