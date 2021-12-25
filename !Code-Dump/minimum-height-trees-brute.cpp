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

vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
    int arr[n][n];
    forn(i, n){
        forn(j, n){
            arr[i][j] = INT_MAX;
        }
    }
    for (int it=0; it < edges.size(); it++) {
        int i = edges[it][0], j = edges[it][1];
        arr[i][j] = arr[j][i] = 1;
    }
    forn(i, n){
        forn(j, n){
            forn(k, n){
                arr[i][j] = arr[j][i] = ((arr[i][k] == INT_MAX) || (arr[k][j] == INT_MAX))?arr[i][j]:min(arr[i][j], (arr[i][k]+arr[k][j]));
            }
        }
    }
    forn(i, n){
        arr[i][i] = 0;
    }
    int ht[n];
    vector<int> minHtRoots;
    int minHt = INT_MAX;
    forn(i, n){
        ht[i] = 0;
        forn(j, n){
            ht[i] = max(ht[i],arr[i][j]);
        }
        minHt = min(ht[i],minHt);
    }
    forn(i, n)
        if (ht[i]==minHt){
            minHtRoots.push_back(i);
        }
    // cout << "minht = " << minHt << endl;
    return minHtRoots;
}


int main(){
    fastio();
    // vector<vector<int>> edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    vector<vector<int>> edges = {{1,0},{1,2},{1,3}};
    vector<int> res = findMinHeightTrees(4, edges);
    for (int it; it<res.size(); it++){
        cout << res[it] << endl;
    }
    return 0;
}