class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Circle inside Rectangle
        if (x1 <= xCenter && x2 >= xCenter && y1 <= yCenter && y2 >= yCenter)
            return true;

        // Circle on a side of Rectangle
        if (x1 <= xCenter && x2 >= xCenter && y2 <= yCenter && yCenter - y2 <= radius) // top
            return true;
        if (x1 <= xCenter && x2 >= xCenter && y1 >= yCenter && y1 - yCenter <= radius) // bottom
            return true;
        if (y1 <= yCenter && y2 >= yCenter && x1 >= xCenter && x1 - xCenter <= radius) // left
            return true;
        if (y1 <= yCenter && y2 >= yCenter && x2 <= xCenter && xCenter - x2 <= radius) // left
            return true;

        // Circle in corner of Rectangle cases
        if (distSquare(xCenter, yCenter, x1, y1) <= radius * radius) // bottom left
            return true;
        if (distSquare(xCenter, yCenter, x2, y2) <= radius * radius) // top right
            return true;
        if (distSquare(xCenter, yCenter, x1, y2) <= radius * radius) // top left
            return true;
        if (distSquare(xCenter, yCenter, x2, y1) <= radius * radius) // bottom right
            return true;

        return false;
    }

    long distSquare(int x1, int y1, int x2, int y2) {
        return (long) Math.pow(x1 - x2, 2) + (long) Math.pow(y1 - y2, 2);
    }
}