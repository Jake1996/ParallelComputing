#include <fstream>
#include <iostream>
#include <string>
#include <cstring>
#include <complex>
#include <utility>
#include <cmath>
#include <limits.h>
#include <set>
#include <vector>
#include <map>
#include <cctype>
#include <queue>
#include <stdio.h>
#include <cstdio>
#include <stack>
#include <algorithm>
#include <list>
#include <sys/time.h>
#include <ctime>
#include <time.h>
#include <stdlib.h>
#include <numeric>
#include <memory.h>
#include <omp.h>
#define all(a) (a).begin(),(a).end()
#define gcd __gcd
#define bitcount __builtin_popcount
#define d 256 //for 256 bit ASCII number

using namespace std;

typedef std::vector<int> vi;
typedef std::vector<std::string> vs;
typedef std::pair<int, int> pii;
typedef std::set<int> si;
typedef std::map<std::string, int> msi;

int RabinKarp(string text, string pattern, int prime) {
  int textlength = text.length() ;
  int pattlength = pattern.length() ;
  int p = 0 ; //hash value for pattern
  int t = 0 ; //hash value for text
  int h = 1 ;
  int c ;
  int total=0;
  // h = (d^(pattlength-1)) % prime
  for(int i=0;i<pattlength-1;i++)
    h = (d * h) % prime ;

  //calculating hash values for pattern and first window of text
  for(int i=0;i<pattlength;i++) {
     p = (d * p + pattern[i]) % prime ; //ascii of letters is being used here
     t = (d * t + text[i]) % prime ;
  }

  for(int i=0;i<textlength;i++) {
    c = 0; //dont forget this ...whooff!
    if(p==t) { //if hash matches do naive approach
      for(int j=0;j<pattlength;j++) {
        c++ ;
        if(text[i+j]!=pattern[j])
          break ;
      }
      if(c==pattlength) {
        total++ ;
      }
    }
    //calcualting hash of next text window
    if(i < textlength-pattlength) {
      t = (d * (t - text[i] * h) + text[i+pattlength]) % prime ;
      if(t<0)  //only if it turns out to be negative
        t = t + prime ;
    }
}
return total;
}

int main(int argc, char const *argv[]) {
  string text, pattern ;
  cin>>text;
  int n;
  cin>>n;
  int prime = 101 ; //random prime number
  while(n--!=0) {
    cin>>pattern;
    int k = RabinKarp(text, pattern, prime) ; 
    cout<<k<<endl;
    //cout<<elapsed<<endl;
  }
  return 0;
}