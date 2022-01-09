class Solution {
public:
    bool isRobotBounded(string instructions) {
        array <int, 4> directn; //NESW
        for (int i=0; i<4; i++)
            directn[i]=0;
        int facing = 0;
        for(int k=0; k<4; k++){            
            for (int i=0; i< instructions.length(); i++){
                if(instructions[i]=='G')
                    directn[facing]++;
                else if(instructions[i]=='R')
                    facing++;
                else if(instructions[i]=='L')
                    facing--;
                if (facing>=4)
                    facing %= 4;
                else if(facing<0)
                    facing += 4;
            }
            if(directn[0]==directn[2] && directn[1]==directn[3])    //premature stopping, no need to check further
                return true;    // optimisation, otherwise not reqd
        }
        return (directn[0]==directn[2] && directn[1]==directn[3]);
    }
};