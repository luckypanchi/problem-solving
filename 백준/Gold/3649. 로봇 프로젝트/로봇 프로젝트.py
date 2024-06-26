import sys

input = sys.stdin.readline


while True:
    try:
        x = int(input())
        x *= 10000000
        n = int(input())
        legos = [int(input()) for _ in range(n)]
        legos.sort()

        left = 0
        right = n - 1
        flag = False
        while left < right:
            s = legos[left] + legos[right]
            if s == x:
                print(f"yes {legos[left]} {legos[right]}")
                flag = True
                break
            elif s < x:
                left += 1
            else:
                right -= 1

        if not flag:
            print("danger")

    except:
        break
