import sys

input = sys.stdin.readline


def count(target):
    result = 0
    for i in range(n):
        result += find(target // a[i])
    return result


def find(bTarget):
    left = 0
    right = n - 1
    result = 0

    while left <= right:
        mid = (left + right) // 2
        if b[mid] <= bTarget:
            result = mid + 1
            left = mid + 1
        else:
            right = mid - 1

    return result


n, k = map(int, input().split())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))

left = a[0] * b[0]
right = a[-1] * b[-1]
answer = 0

while left <= right:
    mid = (left + right) // 2
    c = count(mid)

    if k <= c:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)