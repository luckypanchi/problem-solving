import sys
input = sys.stdin.readline

def main():
    n = int(input())
    cnt_2 = 0
    cnt_5 = 0

    for num in range(1, n+1):
        tmp = num
        while tmp%2 == 0:
            tmp = tmp//2
            cnt_2 += 1

        while tmp%5 == 0:
            tmp = tmp//5
            cnt_5 += 1

    print(min(cnt_2, cnt_5))

if __name__ == "__main__":
    main()