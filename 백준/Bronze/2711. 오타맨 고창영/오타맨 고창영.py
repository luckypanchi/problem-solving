tc = int(input())
for _ in range(tc):
    n, s = input().split()
    n = int(n) - 1
    s = list(s)
    print("".join(s[:n] + s[n + 1:]))