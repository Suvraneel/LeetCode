class Solution {
public:
    string addBinary(string a, string b) {
        string c="";
        int cy = 0;
        int sizeA = a.length(), sizeB = b.length();
        if (sizeA<sizeB){
            a = string(sizeB-sizeA+1,'0')+a;
            b = "0"+b;
        }
        else {
            b = string(sizeA-sizeB+1,'0')+b;
            a = "0"+a;
        }
        cout << a << "           " << b << endl;
        int len = max(a.length(), b.length());
        for (int i=1; i<=len; i++){
            int binA = a[len-i]-'0', binB = b[len-i]-'0';
            cout << binA <<"$"<< binB << endl;
            c = to_string((binA + binB + cy)%2) + c;
            cy = (binA + binB + cy)/2;
            cout << c << endl;
        }
        while(c[0]=='0'){
            c = c.substr(1);
        }
        if (!(c.length()))
            return "0";
        return c;
    }
};