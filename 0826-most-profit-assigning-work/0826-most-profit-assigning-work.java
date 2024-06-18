class Solution {
    public class Job implements Comparable<Job> {

        public int difficulty;
        public int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public boolean canDo(int skill){
            return skill>=this.difficulty;
        }

        @Override
        public int compareTo(Job other) {
            if (this.difficulty == other.difficulty)
                return Integer.compare(other.profit, this.profit);
            return Integer.compare(this.difficulty,other.difficulty);
        }

        @Override
        public String toString() {
            return ("{Difficulty:" + this.difficulty + ", Profit:" + this.profit + "}");
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        // Queue<Job> pq = new PriorityQueue<>();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Job(difficulty[i], profit[i]);
        Arrays.sort(jobs);
        // for (Job j: jobs)
        //     System.out.println(j.toString());

        Arrays.sort(worker);
        int ans = 0, i = 0, maxWorth = 0;
        for (int w: worker){
            while(jobs[i].canDo(w)){
                maxWorth = Math.max(maxWorth, jobs[i].profit);
                i++;
            }
            ans += maxWorth;
        }
        return ans;
    }
}