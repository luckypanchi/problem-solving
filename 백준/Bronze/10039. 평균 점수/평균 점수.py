points = [int(input()) for _ in range(5)]
for i in range(5):
    points[i] = max(points[i], 40)
    
print(sum(points) // 5)