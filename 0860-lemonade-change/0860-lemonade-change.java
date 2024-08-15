class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5 = 0, c10 = 0;
        for (int b : bills) {
            switch (b) {
                case 5 -> c5++;
                case 10 -> {
                    c10++;
                    if (c5 <= 0)
                        return false;
                    c5--;
                }
                case 20 -> {
                    if(c5==0)
                        return false;
                    if (c10 == 0){
                        if(c5<3)
                            return false;
                        c5-=3;
                    } else {
                        c5--;
                        c10--;
                    }
                }
            }
        }
        return true;
    }
}