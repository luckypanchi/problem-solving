n = int(input())
zero = 0
one = 0
for _ in range(n):
    a = int(input())
    if a == 0:
        zero += 1
    else:
        one += 1
        
if one < zero:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")