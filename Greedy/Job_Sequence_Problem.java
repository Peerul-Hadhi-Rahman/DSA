class Solution {
    
    static class Job {
        int deadline;
        int profit;
        
        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit=profit;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
       int n=deadline.length;
       
       //create job list
       Job[] jobs=new Job[n];
       for(int i=0;i<n;i++) {
           jobs[i]=new Job(deadline[i], profit[i]);
       }
       
       //sort by decending profit
       Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
       
       //Maximum deadline
       int maxDeadline=0;
       for(Job job : jobs) {
           maxDeadline=Math.max(maxDeadline, job.deadline);
       }
       
       //create slots
       int[] slot=new int[maxDeadline+1];
       Arrays.fill(slot, -1);
       
       int countJobs=0;
       int totalProfit=0;
       
       //Assign Jobs
       for(Job job:jobs) {
           for(int j=job.deadline;j>0;j--) {
               if(slot[j]==-1) {
                   slot[j]=1;
                   countJobs++;
                   totalProfit+=job.profit;
                   break;
               }
           }
       }
       
       ArrayList<Integer> result = new ArrayList<>();
       result.add(countJobs);
       result.add(totalProfit);
       
       return result;
        
    }
}
