#include <bits/stdc++.h>
using namespace std;
#define MAX 100005
#define ll long long
#define pb push_back
struct point{
    int x, y;
};
point p[MAX];
bool cmp_x(const point &a, const point &b){
    return a.x < b.x;
}
bool cmp_y(const point &a, const point &b){
    return a.y < b.y;
}
ll dist(point a, point b){
    return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
}
ll closest_pair(int l, int r){
    if(l == r) return 1e18;
    if(r - l == 1) return dist(p[l], p[r]);

    int m = (l + r) / 2;
    ll d = min(closest_pair(l, m), closest_pair(m + 1, r));

    vector<point> b;
    for(int i = l; i <= r; i++){
        if(abs(p[i].x - p[m].x) * abs(p[i].x - p[m].x) <= d)
            b.pb(p[i]);
    }
    sort(b.begin(), b.end(), cmp_y);
    for(int i = 0; i < b.size(); i++){
        for(int j = i + 1; j < b.size() && j < i + 7; j++){
            d = min(d, dist(b[i], b[j]));
        }
    }
    return d;
}
int main(){
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> p[i].x >> p[i].y;
    }
    sort(p, p + n, cmp_x);
    cout << closest_pair(0, n - 1) << endl;
    return 0;
}