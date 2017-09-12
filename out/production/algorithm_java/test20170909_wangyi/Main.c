#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
#include <map>
#include <set>
#include <queue>
#include <iterator>
#include <cstdlib>
#include <cstdio>
#include <cmath>
using namespace std;


int main()
{
int t;
while(cin>>t)
    {
        while(t--)
        {
            int n;
            cin>>n;
            vector<int> array(n);
            for(int i=0;i<n;++i)
                cin>>array[i];
            int count4=0;
            int count1=0;
            for(int i=0;i<n;++i)
            {
                if(array[i]%2)count1++;
                else if(array[i]%4==0) count4++;
            }
            if(count1<=count4)cout<<"Yes"<<endl;
            else cout<<"No"<<endl;
        }
    }
return 0;
} 
