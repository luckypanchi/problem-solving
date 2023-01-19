import sys
input = sys.stdin.readline
from itertools import combinations

def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    chicken = []
    home = []

    for i in range(n):
        for j in range(n):
            if matrix[i][j] == 1: home.append((i, j))
            if matrix[i][j] == 2: chicken.append((i, j))

    def getDistance(curr):
        y, x = curr
        dist = 9999

        for cand in dest:
            tmp = abs(y-cand[0]) + abs(x-cand[1])
            dist = min(dist, tmp)
        
        return dist

    def getTotalDist():
        total = 0

        for curr in home:
            total += getDistance(curr)

        return total

    dest = []

    answer = 9999
    for i in range(1, m+1):
        for tmp in list(combinations(chicken, i)):
            for loc in tmp:
                dest.append(loc)
            answer = min(answer, getTotalDist())
            dest = []


    print(answer)


if __name__ == "__main__":
    main()