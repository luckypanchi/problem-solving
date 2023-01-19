import sys

input = sys.stdin.readline


n, k = map(int, input().split())


def getNum(num):
    return (num + 1) * (n - num + 1)


start = 0
end = n // 2

while start <= end:
    mid = (start + end) // 2
    num = getNum(mid)

    if num == k:
        print("YES")
        sys.exit()

    elif num < k:
        start = mid + 1
    else:
        end = mid - 1

print("NO")
