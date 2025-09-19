class Spreadsheet {
    int[][] cells;

    public Spreadsheet(int rows) {
        cells = new int[rows][27];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        cells[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        cells[row][col] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] expr = formula.split("\\+");
        int val1, val2;
        if (Character.isAlphabetic((int) (expr[0].charAt(0)))) {
            int col = expr[0].charAt(0) - 'A';
            int row = Integer.parseInt(expr[0].substring(1));
            val1 = cells[row][col];
        } else
            val1 = Integer.parseInt(expr[0]);
        if (Character.isAlphabetic((int) (expr[1].charAt(0)))) {
            int col = expr[1].charAt(0) - 'A';
            int row = Integer.parseInt(expr[1].substring(1));
            val2 = cells[row][col];
        } else
            val2 = Integer.parseInt(expr[1]);
        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */