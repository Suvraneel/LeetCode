class Solution {
    public int findTheLongestSubstring(String s) {
        int as = 0, es = 0, is = 0, os = 0, us = 0;
        for (int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a' -> as++;
                case 'e' -> es++;
                case 'i' -> is++;
                case 'o' -> os++;
                case 'u' -> us++;
            }
        }

        if (as % 2 == 0 && es % 2 == 0 && is % 2 == 0 && os % 2 == 0 && us % 2 == 0) {
            return s.length();
        }

        int left = 0;
        int right = s.length();
        boolean nextLeft = false;
        while (right - left > 0) {
            char removed = nextLeft ? s.charAt(left++) : s.charAt(right-- - 1);
            switch (removed) {
                case 'a' -> as--;
                case 'e' -> es--;
                case 'i' -> is--;
                case 'o' -> os--;
                case 'u' -> us--;
            }

            if (as % 2 == 0 && es % 2 == 0 && is % 2 == 0 && os % 2 == 0 && us % 2 == 0) {
                return right - left;
            }

            for (int i = 0; i < s.length() - (right - left); i++) {
                removed = nextLeft ? s.charAt(right-- - 1) : s.charAt(left ++);
                char added = nextLeft ? s.charAt(--left) : s.charAt(++right - 1);
                switch (removed) {
                    case 'a' -> as--;
                    case 'e' -> es--;
                    case 'i' -> is--;
                    case 'o' -> os--;
                    case 'u' -> us--;
                }
                switch (added) {
                    case 'a' -> as++;
                    case 'e' -> es++;
                    case 'i' -> is++;
                    case 'o' -> os++;
                    case 'u' -> us++;
                }

                if (as % 2 == 0 && es % 2 == 0 && is % 2 == 0 && os % 2 == 0 && us % 2 == 0) {
                    return right - left;
                }
            }
            nextLeft = !nextLeft;
        }

        return 0;
    }
}