class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length, v2.length), i;
        for (i = 0; i < len; i++) {
            int v1i = Integer.parseInt(v1[i]);
            int v2i = Integer.parseInt(v2[i]);
            if (v1i == v2i)
                continue;
            return v1i < v2i ? -1 : 1;
        }
        if (v1.length < v2.length)
            for (; i < v2.length; i++)
                if (Integer.parseInt(v2[i]) > 0)
                    return -1;
        if (v1.length > v2.length)
            for (; i < v1.length; i++)
                if (Integer.parseInt(v1[i]) > 0)
                    return 1;
        return 0;
    }
}