import sys
input = sys.stdin.readline

def main():
    matrix = [int(input()) for _ in range(10)]

    total = 0
    answer = 0

    for i in matrix:
        if total <= 100 and total + i >= 100:
            if abs(total - 100) < abs(total + i - 100):
                break
            else:
                total = total + i
                break
        else:
            total += i
    
    print(total)


if __name__ == "__main__":
    main()