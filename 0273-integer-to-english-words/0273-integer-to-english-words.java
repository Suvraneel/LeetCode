class Solution {
    public static String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    public static String[] teens = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    public static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0)
            return "Zero";
        getWord(sb, num);
        return sb.toString().trim();
    }

    public void getWord(StringBuilder sb, int n) {
        if (n >= 1e9) {
            int prefix = (int) (n / 1e9);
            getWord(sb, prefix);
            sb.append(" Billion");
            n %= 1e9;
        } 
        if (n >= 1e6) {
            int prefix = (int) (n / 1e6);
            getWord(sb, prefix);
            sb.append(" Million");
            n %= 1e6;
        } 
        if (n >= 1e3) {
            int prefix = (int) (n / 1e3);
            getWord(sb, prefix);
            sb.append(" Thousand");
            n %= 1e3;
        } 
        if (n >= 1e2) {
            int prefix = (int) (n / 1e2);
            getWord(sb, prefix);
            sb.append(" Hundred");
            n %= 1e2;
        } 
        if (n >= 20) {
            int prefix = n / 10;
            sb.append(" " + tens[prefix]);
            n %= 10;
        } else if (n >= 10){
            sb.append(" " + teens[n - 10]);
            return;
        }
        if (n > 0)
            sb.append(" " + units[n]);
    }
}