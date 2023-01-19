import sys

def main():
    num = int(sys.stdin.readline())
    counter = 0
    for i in range(1, num+1):
        tmp = [int(x) for x in str(i)]
        if len(tmp) == 1 or len(tmp) == 2:
            counter += 1
        else: 
            dif = tmp[1] - tmp[0]
            for j in range(1, len(tmp)-1):
                if tmp[j+1] - tmp[j] != dif: break
                counter += 1
    print(counter)

main()