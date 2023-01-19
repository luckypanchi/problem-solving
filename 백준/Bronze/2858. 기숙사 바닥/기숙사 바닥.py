import sys
input = sys.stdin.readline

def main():
    r, b = map(int, input().split())

    x, y = 0, 0
    l, w = 0,0
    stop = False

    for y in range(r//2):
        for x in range(r//2):
            if 2*x+2*y-4==r and (x-2)*(y-2)==b:
                l = max(x, y)
                w = min(x, y)
                stop = True
                break
        if stop: break

    print(l, w)


if __name__ == "__main__":
    main()