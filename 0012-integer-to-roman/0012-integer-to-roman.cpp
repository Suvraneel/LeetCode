class Solution {
public:
    // string intToRoman(int num) {
    //     map <int, string> m;
    //     m = {{1,"I"},{4,"IV"},{5,"V"},{9,"IX"},{10,"X"},{40,"XL"},{50,"L"},{90,"XC"},{100,"C"},{400,"CD"},{500,"D"},{900,"CM"},{1000,"M"}};
    //     string res="";
    //     for(auto it=m.rbegin(); it!=m.rend(); it++) //map::reverse_iterator it
    //         while(num>=it->first)
    //             num-=it->first, res+=it->second;
    //     return res;
    // }
    
    string intToRoman(int num) {
        vector <string> vUnits(10), vTens(10), vHundreds(10), vThousands(3);
        vUnits     = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        vTens      = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        vHundreds  = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        vThousands = {"","M","MM","MMM"};
        return vThousands[num/1000] + vHundreds[num%1000/100] + vTens[num%100/10] + vUnits[num%10];
    }
};