import sys
from collections import deque

def main():
    n = int(sys.stdin.readline())

    answer = []

    for _ in range(n):
        v, e = map(int, sys.stdin.readline().split())
        matrix = [[] for _ in range(v+1)]

        for _ in range(e):
            a, b = map(int, sys.stdin.readline().split())
            matrix[a].append(b)
            matrix[b].append(a)
        
        color = [0]*(v+1)
        
        def bfs(start):
            que = deque()
            que.append(start)
            color[start] = 1
            while que:
                tmp = que.popleft()
                for i in matrix[tmp]:
                    if color[i] == 0:
                        que.append(i)
                        color[i] = -1*color[tmp]
                    elif color[i] == color[tmp]: 
                        return False
            return True

        isTrue = True
        for i in range(1, v+1):
            if color[i] == 0:
                if not bfs(i):
                    isTrue = False                    
                    break
        
        if isTrue: answer.append('YES')
        else: answer.append('NO')

    for i in answer:
        print(i)
    
if __name__ == "__main__":
    main()