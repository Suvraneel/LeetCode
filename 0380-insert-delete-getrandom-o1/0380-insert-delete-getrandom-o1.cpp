class RandomizedSet {
public:
    unordered_set <int> s;
    vector<int> v;
    
    bool insert(int val) {
        if (s.find(val)!=s.end())   // found
            return false;
        s.insert(val);
        v.push_back(val);
        return true;
    }
    
    bool remove(int val) {
        auto it = s.find(val);
        if (it==s.end())   // not found
            return false;
        s.erase(it);
        auto it2 = find(v.begin(), v.end(), val);
        v.erase(it2);
        return true;
    }
    
    int getRandom() {
        return v[rand()%v.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */