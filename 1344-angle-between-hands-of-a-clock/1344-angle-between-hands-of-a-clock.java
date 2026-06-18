class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 360d / 60d;
        double hourAngle = hour * 360d / 12d + minutes * 360d / 12d / 60d;
        double diff = Math.abs(minuteAngle - hourAngle);
        return Math.min(diff, 360 - diff);
    }
}