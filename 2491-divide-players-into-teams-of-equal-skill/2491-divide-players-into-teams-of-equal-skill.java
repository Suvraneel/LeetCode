class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long sum = skill[0] + skill[n-1], pdt = 0;
        for(int i=0; i<n/2; i++){
            if(skill[i]+skill[n-1-i]!=sum)
                return -1;
            pdt += skill[i] * skill[n-1-i];
        }
        return pdt;
    }
}