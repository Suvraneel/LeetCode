class TimeMap {
public:
    unordered_map <string, vector<pair<int, string>>> m;
    
    // TimeMap() {      // default constructor unnecessary
    //     m.clear();
    // }
    
    void set(string key, string value, int timestamp) {
        m[key].push_back(make_pair(timestamp, value));
        // All the timestamps `timestamp` of `set` are strictly increasing.  
        // So no need to worry about resetting the value of a already fed timestamp
    }
    
    string get(string key, int timestamp) {
        // Given Constraint: All the timestamps `timestamp` of `set` are strictly increasing.
        // Hence, the vector is already sorted
        auto& v = m[key];
        // Given Constraint: All the timestamps `timestamp` of `set` are strictly increasing.
        // Hence, the vector is already sorted
        auto it = upper_bound(v.begin(), v.end(), pair<int, string>(timestamp, ""), 
                              [](auto& a, auto& b){ return a.first<b.first;});
        // upper_bound => binary search with a special comparator as lambda fx 
        return it==v.begin() ? "" : prev(it)->second;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */