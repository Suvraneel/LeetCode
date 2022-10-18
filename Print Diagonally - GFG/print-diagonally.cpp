//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	public:
	vector<int> downwardDigonal(int N, vector<vector<int>> A)
	{
		// Your code goes here
		vector<int> V;
		for(int sum=0; sum<=(A.size()-1)* 2; sum++){
		    int row=sum>=A.size()?sum-A.size()+1:0;
		  //  cout << "sum" << sum << "row:" << row<< endl;
		    while(row<=sum && row<A.size()){
		        int col=sum-row;
		      //  cout << row << "\t" << col << endl;
		        V.push_back(A[row++][col]);
		    }
		}
		return V;
	}

};

//{ Driver Code Starts.



int main()
{

    
    int t;
    cin >> t;
    while(t--) 
    {
        int n;
        cin >> n;

        vector<vector<int>> A(n, vector<int>(n));

        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		cin >> A[i][j];

        Solution obj;
        vector<int> ans = obj.downwardDigonal(n, A);

        for(auto i:ans)
        	cout << i << " ";

	    cout << "\n";
    }

    return 0;
}

// } Driver Code Ends