import sys

input = sys.stdin.readline

n, m = map(int, input().split())
packages = []
singles = []

for _ in range(m):
    a, b = map(int, input().split())
    packages.append(a)
    singles.append(b)

package_min = min(packages)
single_min = min(singles)

candidates = []

candidates.append((n // 6 + 1) * package_min)
candidates.append(n * single_min)
candidates.append(n // 6 * package_min + n % 6 * single_min)

print(min(candidates))
