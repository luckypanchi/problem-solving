import sys

def main():
    n = int(sys.stdin.readline())
    matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    rank = []

    for arr in matrix:
        cnt = 1
        for arr2 in matrix:
            if arr[0] < arr2[0] and arr[1] < arr2[1]:
                cnt += 1
        
        rank.append(cnt)

    print(*rank)
    
if __name__ == "__main__":
    main()