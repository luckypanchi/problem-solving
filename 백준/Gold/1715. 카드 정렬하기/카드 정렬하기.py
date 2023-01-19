import heapq
import sys

def main():
    n = int(sys.stdin.readline())
    li = []
    for _ in range(n):
        heapq.heappush(li, int(sys.stdin.readline()))

    if n == 1: answer = 0
    else:
        answer = 0
        while len(li) > 1:
            tmp1 = heapq.heappop(li)
            tmp2 = heapq.heappop(li)
            answer += tmp1 + tmp2
            heapq.heappush(li, tmp1 + tmp2)
    
    print(answer)

if __name__ == "__main__":
    main()