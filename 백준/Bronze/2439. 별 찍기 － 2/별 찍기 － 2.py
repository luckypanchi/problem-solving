n = int(input())

for i in range(n):
    a = "*" * (i+1)
    print(a.rjust(n, " "))