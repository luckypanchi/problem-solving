import sys
input = sys.stdin.readline
from itertools import combinations

def main():
    n, l, r, x = map(int, input().split())
    level = list(map(int, input().split()))

    candidates = []
    cnt = 0

    for i in range(2, n+1):
        candidates += list(combinations(level, i))
    
    for arr in candidates:
        if l <= sum(arr) <= r and x <= max(arr) - min(arr):
            cnt += 1

    print(cnt)

if __name__ == "__main__":
    main()