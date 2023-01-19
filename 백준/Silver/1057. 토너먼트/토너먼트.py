import sys
input = sys.stdin.readline

def main():
    r, n, m = map(int, input().split())

    small = min(n, m)
    big = max(n, m)
    round = 0

    while r != 1:
        if r%2: r += 1
        r = r//2
        round += 1

    def calc(num):
        if num%2: return (num+1)//2
        else: return num//2

    answer = -1
    for i in range(1, round+1):
        if small%2 and small+1==big:
            answer = i
            break
        small = calc(small)
        big = calc(big)

    print(answer)

if __name__ == "__main__":
    main()