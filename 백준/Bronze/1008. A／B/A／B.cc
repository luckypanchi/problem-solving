#include <iostream>

using namespace std;

int main(void) {
    int a, b;
    cin>>a>>b;

    double c = (double)a/b;

    cout.precision(16);
    cout<<c<<endl;
    return 0;
}