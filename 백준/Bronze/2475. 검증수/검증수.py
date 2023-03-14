numbers = map(int, input().split())
s = 0
for num in numbers:
    s += num ** 2
    
print(s % 10)
    