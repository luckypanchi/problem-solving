import sys
from collections import Counter

input = sys.stdin.readline


n = int(input())
dic = Counter(list(map(int, input().split())))
target = int(input())
print(dic[target])