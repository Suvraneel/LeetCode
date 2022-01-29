class Solution {
public:
 int largestRectangleArea(vector<int>& heights) {
        stack<pair<int, int>> st;
        st.push(make_pair(-1, 0));
        int maxArea = -1;
        for(int i=0; i<heights.size(); i++){
            if(heights[i]>=st.top().second) {
                st.push(make_pair(i, heights[i]));
            }else{
                while(st.top().second>heights[i]){
                    pair<int, int> bar = st.top();
                    st.pop();
                    maxArea = max(maxArea, (int)(bar.second*(i-st.top().first-1)));
                }
                st.push(make_pair(i,heights[i]));
            }
        }
        
        /*  
            At this point in the traversal all the elements remaining in the stack are in a non decreasing order (i.e. 
            st.top() will always be greater than or equal to any element in the stack) and it's assured that the last element
            of heights is greater or equal to the top of the stack i.e. heights[heights.size()-1]>=st.top()
        */
        
        while(st.top().first!=-1){
            pair<int, int> bar = st.top();
            st.pop();
            maxArea = max(maxArea, (int)(bar.second*(heights.size()-st.top().first-1)));
        }
        
        return maxArea;
    }
};