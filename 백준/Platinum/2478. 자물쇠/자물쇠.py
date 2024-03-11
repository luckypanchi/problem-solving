import sys

input = sys.stdin.readline


def check(array, p, q):
    if p == 0 and q == n - 1:
        if array[0] == n or array[-1] == 1:
            return False
    elif p == 0 and array[q] == 1:
        return False
    elif q == n - 1 and array[p] == n:
        return False
    elif array[0] == 1 or array[-1] == n:
        return False

    return True


n = int(input())
array = list(map(int, input().split()))
flipped = []
isFlipped = False

k1, k2 = 0, 0
p, q = 0, 0

for i in range(n):
    j = (i + 1) % n
    if array[i] == array[j] + 1 or (array[i] == 1 and array[j] == n):
        if not isFlipped:
            isFlipped = True
            flipped.append(i)
        if isFlipped:
            flipped.append(j)
    elif isFlipped:
        isFlipped = False

flipped = sorted(list(set(flipped)))

p = flipped[0]
q = flipped[-1]
for i in range(len(flipped) - 1):
    if flipped[i] + 1 != flipped[i + 1]:
        p = flipped[i + 1]
        q = flipped[i]
        break

if p != 0:
    k2 += n - p
    array = array[p:] + array[:p]
    p = 0
    q = (q + k2) % n

if len(flipped) == n:
    p = 0
    q = n - 1

while not check(array, p, q) or k2 == 0:
    array = [array[-1]] + array[:-1]
    k2 += 1
    if len(flipped) != n:
        p += 1
        q += 1

array = array[:p] + array[p : q + 1][::-1] + array[q + 1 :]

k1 = n - array.index(1)

print(k1)
print(p + 1, q + 1)
print(k2)