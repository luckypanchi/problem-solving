import sys

input = sys.stdin.readline


n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

array1 = []
array2 = []
for i in range(n):
    array1.append((a[i], i))

for i in range(m):
    array2.append((b[i], i))

array1.sort(key=lambda x: (-x[0], x[1]), reverse=True)
array2.sort(key=lambda x: (-x[0], x[1]), reverse=True)

index1 = -1
index2 = -1
answer = []
while array1 and array2:
    if array1[-1][0] == array2[-1][0] and index1 < array1[-1][1] and index2 < array2[-1][1]:
        answer.append(array1[-1][0])
        _, idx1 = array1.pop()
        _, idx2 = array2.pop()
        index1 = idx1
        index2 = idx2
    elif array1[-1][0] < array2[-1][0] or array2[-1][1] < index2:
        array2.pop()
    else:
        array1.pop()

print(len(answer))
print(*answer)