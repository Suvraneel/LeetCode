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

int maximalSquare(vector<vector<char>>& matrix) {
    int m = matrix.size(), n = matrix[0].size();
    int res[m+1][n+1];
    for(int i = 0; i < m+1; i++) 
        res[i][0] = 0;
    for(int i = 0; i < n+1; i++) 
        res[0][i] = 0;
    for(int i = 1; i < m+1; i++) {
        for(int j = 1; j < n+1; j++) {
            if(matrix[i-1][j-1]=='0')
                res[i][j] = res[i][j-1]; //+0
            else res[i][j]=res[i][j-1]+1; //+1
            cout << res[i][j] << ' ';
        }
        cout << endl;
    }
    cout << "------------------------" << endl;
    for(int i = 1; i < m+1; i++) {
        for(int j = 1; j < n+1; j++) {
            res[i][j] += res[i-1][j];
            cout << res[i][j] << ' ';
        }
        cout << endl;
    }
    int ans = 0, temp;
    for(int i = 1; i < m+1; i++) {
        for(int j = 1; j < n+1; j++) {
            for(int k = 1; k <= min(i, j); k++) {
                temp = res[i][j] - res[i-k][j] - res[i][j-k] + res[i-k][j-k];
                if(temp==k*k)
                    ans = max(ans, temp);
            }
        }
    }
    return ans;
}

int main(){
    fastio();
    vector<vector<char>> mat;
    // mat = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    mat = {{'0','1'},{'1','0'}};
    cout << maximalSquare(mat);
    return 0;
}