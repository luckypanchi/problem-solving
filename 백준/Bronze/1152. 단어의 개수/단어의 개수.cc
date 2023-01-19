#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string temp;
    getline(cin, temp);

    int i = 0;
    int count = 1;

    if((temp.length() == 1) && temp[0] == ' ') {
        count = 0;
    } else {
        while(temp[i] != '\0') {
            if(temp[i] == ' ') {
                if((i != 0) && (temp[i+1] != '\0')) {
                    count++;
                }
            }
            i++;
        }
    }

    cout<<count<<endl;

    return 0;
}