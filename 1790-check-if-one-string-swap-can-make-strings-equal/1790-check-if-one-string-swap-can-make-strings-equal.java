class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        List<Integer> idx = new ArrayList<>();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i))
                if(idx.size()>=2)
                    return false;
                else idx.add(i);
        }
        if(idx.size()==1)
            return false;
        return s1.charAt(idx.get(0)) == s2.charAt(idx.get(1)) 
        && s1.charAt(idx.get(1)) == s2.charAt(idx.get(0));
    }
}