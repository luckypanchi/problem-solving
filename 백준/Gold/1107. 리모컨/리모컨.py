import sys
input = sys.stdin.readline

def main():
    dest = int(input())
    n = int(input())
    broken = list(map(int, input().split()))

    start = 100
    answer = abs(start-dest)

    def check(tmp):
        for i in broken:
            if str(i) in str(tmp): return False
        return True
    
    for i in range(1000001):
        if check(i): answer = min(answer, len(str(i)) + abs(i-dest))
    
    print(answer)

if __name__ == "__main__":
    main()