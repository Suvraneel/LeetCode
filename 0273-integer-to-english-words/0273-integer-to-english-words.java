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
            getWord(sb, (int) (n % 1e9));
        } else if (n >= 1e6) {
            int prefix = (int) (n / 1e6);
            getWord(sb, prefix);
            sb.append(" Million");
            getWord(sb, (int) (n % 1e6));
        } else if (n >= 1e3) {
            int prefix = (int) (n / 1e3);
            getWord(sb, prefix);
            sb.append(" Thousand");
            getWord(sb, (int) (n % 1e3));
        } else if (n >= 1e2) {
            int prefix = (int) (n / 1e2);
            getWord(sb, prefix);
            sb.append(" Hundred");
            getWord(sb, (int) (n % 1e2));
        } else if (n >= 20) {
            int prefix = n / 10;
            sb.append(" " + tens[prefix]);
            getWord(sb, n % 10);
        } else if (n >= 10)
            sb.append(" " + teens[n - 10]);
        else if (n > 0)
            sb.append(" " + units[n]);
    }
}