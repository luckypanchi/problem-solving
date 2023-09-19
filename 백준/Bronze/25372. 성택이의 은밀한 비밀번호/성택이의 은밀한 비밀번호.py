n = int(input())
for _ in range(n):
    s = input().strip()
    if 6 <= len(s) <= 9:
        print("yes")
    else:
        print("no")