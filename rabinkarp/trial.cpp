#include <iostream>
#include <omp.h>
using namespace std;
int main() {
    cout<<omp_get_max_threads();
    string s;
    cin>>s;
    cout<<s[s.length()-1];
    int n;
    cin>>n;
    cout<<s.length();
}