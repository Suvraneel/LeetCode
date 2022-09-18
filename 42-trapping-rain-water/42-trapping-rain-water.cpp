class Solution {
public:
    int trap(vector<int>& ht) {
        int res=0, lt=0, rt=0, opq=0;
        for(int i=1; i<ht.size(); i++){
            if(ht[i]<ht[lt]){
                opq+=ht[i];
                rt=i;
            } else {
            res+=(rt-lt)*ht[lt]-opq;
            lt=rt=i;
            opq=0;
            }
            // cout<<i<<".\tLt:"<<lt<<"\tRt:"<<rt<<"\tOpq:"<<opq<<"\t"<<res<<endl;
        }
        int bound = lt;
        cout << bound;
        lt=ht.size()-1, rt=ht.size()-1, opq=0;
        for(int i=ht.size()-1; i>=bound; i--){
            if(ht[i]<ht[lt]){
                opq+=ht[i];
                rt=i;
            } else {
            res+=(lt-rt)*ht[lt]-opq;
            lt=rt=i;
            opq=0;
            }
            // cout<<i<<".\tLt:"<<lt<<"\tRt:"<<rt<<"\tOpq:"<<opq<<"\t"<<res<<endl;
        }
        return res;
    }
};