n, x = map(int, input().split())
matrix = list(map(int, input().split()))

for num in matrix:
    if num < x:
        print(num, end=" ")