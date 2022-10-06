class TimeMap {
public:
    unordered_map <string, map<int, string>> m;
    
    TimeMap() {
        m.clear();
    }
    
    void set(string key, string value, int timestamp) {
        m[key][timestamp]=value;
        // All the timestamps `timestamp` of `set` are strictly increasing.  
        // So no need to worry about resetting the value of a already fed timestamp
    }
    
    string get(string key, int timestamp) {
        // Given Constraint: All the timestamps `timestamp` of `set` are strictly increasing.
        // Hence, the vector is already sorted
        auto it = m[key].upper_bound(timestamp);
        return it==m[key].begin() ? "" : prev(it)->second;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */