//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    struct comparator{
        bool operator()(pair<int, int>a, pair<int, int>b){
            return a.second<b.second;
        }
    };
    //Function to find maximum of each subarray of size k.
    vector <int> max_of_subarrays(int *arr, int n, int k)
    {
        // your code here
        priority_queue <pair<int, int>, vector<pair<int,int>>, comparator> pq;     // Key-Val pair... Index->Element
        for(int i=0; i<k; i++)
            pq.push({i, arr[i]});
        vector<int> v;
        v.push_back(pq.top().second);
        for(int i=k; i<n; i++){
            pq.push({i, arr[i]});
            while(pq.top().first<=i-k)
                pq.pop();
            v.push_back(pq.top().second);
        }
        return v;
    }
};

//{ Driver Code Starts.

int main() {
	
	int t;
	cin >> t;
	
	while(t--){
	    
	    int n, k;
	    cin >> n >> k;
	    
	    int arr[n];
	    for(int i = 0;i<n;i++) 
	        cin >> arr[i];
	    Solution ob;
	    vector <int> res = ob.max_of_subarrays(arr, n, k);
	    for (int i = 0; i < res.size (); i++) 
	        cout << res[i] << " ";
	    cout << endl;
	    
	}
	
	return 0;
}
// } Driver Code Ends