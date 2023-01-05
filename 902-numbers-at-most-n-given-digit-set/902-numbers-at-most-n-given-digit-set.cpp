class Solution {
public:
int atMostNGivenDigitSet(vector<string>& digits, int n) {
    vector<int> d;
    int ch = digits.size();
    // convert to vector of ints instead of string
    for(int i = 0; i < ch; i++)
        d.push_back(stoi(digits[i]));
    int p = log10(n), res=0;
    // all combs with less digits than n's (ie, <p digits)
    for(int i = 1; i <= p; i++){
        res+=pow(ch, i);
    }
    cout << res << endl;
    // combs with p digits but less than n
    string bound = to_string(n);
    for (int i = 0; i <= p; i++){
        bool eq = false;
        int k = (bound[i] - '0');
        cout << k << " -> ";
        // find that digit in vector `d`
        int gti = -1;
        for (int idx = 0; idx < ch; idx++){ // doesnt affect complexity -> Atmost 9 runs
            gti = d[idx]<k ? idx : gti;
            if (d[idx]==k) eq = true;    
        }
        int temp = (gti+1)*pow(ch, p-i);
        res += temp>0 ? temp:0;
        cout << gti+1 << " " << temp << endl;
        if(!eq) break;
    }
    // check if n can be formed with given digits... If yes, +1
    int pdt = 1;
    for(int i = 0; i <= p; i++){
        auto it = find(d.begin(), d.end(), (bound[i] - '0'));
        if (it == d.end())  //not found
            pdt = 0;
    }
    res+=pdt;
    cout << endl << res<< endl;
    return (res);
}

};