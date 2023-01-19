import sys

def main():
    n, k = map(int, sys.stdin.readline().split())
    li = [int(sys.stdin.readline()) for _ in range(n)]

    answer = 0
    li.sort(reverse=True)
    while k>0:
        for i in li:
            if k >= i :
                answer += k//i
                k -= k//i * i
                break
    print(answer)

if __name__ == "__main__":
    main()