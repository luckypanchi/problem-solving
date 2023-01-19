import sys

def main():
    n, m = map(int, sys.stdin.readline().split())
    li = [int(x) for x in sys.stdin.readline().split()]
    li.sort()
    max = 0
    for i in range(0, len(li)-2):
        for j in range(i+1, len(li)-1):
            for k in range(j+1, len(li)):
                getSum =  li[i]+li[j]+li[k]
                if getSum > max and getSum <= m:
                    max = getSum
    print(max)

main()