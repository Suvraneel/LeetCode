#include <bits/stdc++.h>
using namespace std;
typedef long int ll;
typedef long double ld;
#define T int tt; cin >> tt; while(tt--)
#define infLoop while(true)
#define pb push_back
#define mp make_pair
#define forn(i, n) for(ll i = 0; i < n; i++)
#define fora(i, a, n) for(ll i = a; i < n; i++)
#define forr(i, a, n) for(ll i = n-1; i >= a; i--)
const int M = 1e9+7;

void fastio(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
}

vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
    vector<vector<int> > res;
    int diff = INT_MAX;
    sort(arr.begin(), arr.end());
    for(int i = 1; i < arr.size(); i++){
        int temp = arr[i]-arr[i-1];
        cout << "$" << temp << endl;
        if (temp>diff)
            continue;
        if (temp<diff){
            diff = temp;
            res.clear();
        }
        if (temp<=diff)
            res.push_back({arr[i-1],arr[i]});
    }
    return res;
}

int main(){
    fastio();
    vector<int> ip;
    // ip = {3,2,1,4,5};
    ip = {3,8,-10,23,19,-4,-14,27};
    vector<vector<int> > v = minimumAbsDifference(ip);
    for(int i = 0; i < v.size(); i++){
        cout << v[i][0] << " " << v[i][1] << endl;
    }
    return 0;
}