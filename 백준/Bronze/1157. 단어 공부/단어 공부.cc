#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int map[26] = {};
    getline(cin, str);

    for(int i=0; i<str.length(); i++) {
        if(('a' <= str[i]) && (str[i] <= 'z')) {
            map[str[i] - 'a']++;
        } else {
            map[str[i] - 'A']++;
        }
    }

    int max = -1;
    int index = -1;
    int cnt = 0;

    for(int i=0; i<26; i++) {
        if(max == map[i]) {
            cnt++;
        }
        if(max < map[i]) {
            max = map[i];
            index = i;
            cnt = 0;
        }
    }
    
    char c;

    if(cnt != 0) {
        c = '?';
    } else {
        c = (char)(index + 'A');
    }

    cout<<c<<endl;

    return 0;
}