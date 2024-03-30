import sys

input = sys.stdin.readline


l = int(input())
mL, mK = map(int, input().split())
c = int(input())
zombies = [0] + [int(input()) for _ in range(l)]

damages = [0] * (l + 1)
for i in range(1, l + 1):
    d = damages[i - 1] - damages[max(0, i - mL)]

    if zombies[i] <= d + mK:
        damages[i] = damages[i - 1] + mK
    elif c > 0:
        c -= 1
        damages[i] = damages[i - 1]
    else:
        print("NO")
        sys.exit(0)

print("YES")