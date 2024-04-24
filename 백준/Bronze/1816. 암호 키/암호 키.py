import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())
    flag = True
    for i in range(2, 10**6 + 1):
        if n % i == 0:
            flag = False
            print("NO")
            break
    if flag:
        print("YES")