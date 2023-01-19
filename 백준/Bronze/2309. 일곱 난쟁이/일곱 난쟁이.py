import sys

def main():
    li = []
    for _ in range(9):
        li.append(int(sys.stdin.readline()))
    
    total = sum(li)
    tmp1 = tmp2 = 0

    for i in range(8):
        for j in range(i+1, 9):
            if total - li[i] - li[j] == 100:
                tmp1 = li[i]
                tmp2 = li[j]
    
    li.remove(tmp1)
    li.remove(tmp2)

    li.sort()

    for i in li:
        print(i)

if __name__ == "__main__":
    main()