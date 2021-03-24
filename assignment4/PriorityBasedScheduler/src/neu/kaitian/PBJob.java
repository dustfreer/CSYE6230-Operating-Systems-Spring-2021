package neu.kaitian;

public class PBJob implements  Comparable<PBJob> {
    public int jobTime;
    public int priority;
    public PBJob(int jobTime, int priority){
        this.jobTime = jobTime;
        this.priority = priority;
    }

    @Override
    public int compareTo(PBJob job1) {
        if (this.priority == job1.priority) {
            return 0;
        } else if (this.priority > job1.priority) {
            return -1;
        } else {
            return 1;
        }
    }
}
