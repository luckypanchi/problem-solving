import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().strip())) for _ in range(n)]

    limit = min(n, m)
    answer = 0

    def getLength():
        for k in range(limit,0,-1):   
            for i in range(n-k+1):
                for j in range(m-k+1):
                    if matrix[i][j] == matrix[i+k-1][j] == matrix[i][j+k-1] == matrix[i+k-1][j+k-1]:
                        return k

    answer = getLength()
    print(answer*answer)


if __name__ == "__main__":
    main()