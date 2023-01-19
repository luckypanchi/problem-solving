a = int(input())
b = input()
arr = list(map(int, b))[::-1]

for i in arr:
    print(a * i)
    
print(a * int(b))

