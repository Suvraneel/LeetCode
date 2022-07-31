class NumArray {
public:
    vector <int> tree;
    int n;
    NumArray(vector<int>& nums) {
        if (nums.size()>0){
            n = nums.size();
            tree.resize(2*n, 0);
            buildtree(nums);
        }
    }
    
    void buildtree(vector<int>& nums){
        for(int i=n, j=0; i<2*n; i++, j++)  // n to 2n-1 of array `tree`
            tree[i] = nums[j];
        for(int i=n-1; i>0; --i)    // FYI these are parents of n to 2n-1
            tree[i] = tree[2*i] + tree[2*i+1];  // 0 to n-1 of array `tree`
    }
    
    void update(int index, int val) {
        index+=n;                               //update the i b/w n & 2n-1
        tree[index]=val;
        // now the tough part... update all nodes in whom 
        // the changed node had contribution
        while(index>0){
            int lt = index, rt = index;
            if (index%2)
                lt = index-1;
            else rt = index+1;
            tree[index/2] = tree[lt] + tree[rt];    //update parent after child
            index/=2;     // now do their parents (grandparents of leaves & so on)
        }
        
    }
    
    int sumRange(int lt, int rt) {
        // get the lt & rt leaves & then traverse upwards the tree
        lt += n;
        rt += n;
        int sum = 0;
        while (lt<=rt){
            if(lt%2){    // lt is odd => lt is rt child of it parent
                        // => its parent has the lt child's value surplus
                sum+=tree[lt];  // just add up reqd val in sum counter
                lt++;    // and then set lt ptr to child node to its rt
            }
            if(!(rt%2)){    // rt is even => rt is lt child of it parent
                        // => its parent has the rt child's value surplus
                sum+=tree[rt];  // just add up reqd val in sum counter
                rt--;    // and then set rt ptr to child node to its lt
            }
            // at this point both lt & rt ptr are pointing to such leaves such that just finding their common parent will do the reqd task
            lt/=2;
            rt/=2;
        }
        return sum;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */