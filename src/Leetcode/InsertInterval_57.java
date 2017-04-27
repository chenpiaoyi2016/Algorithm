package Leetcode; /**
 * Created by cpy on 2017/2/24.
 */
import java.util.*;

public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //先排序也无妨
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;

        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval=new Interval( Math.min(intervals.get(i).start,newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;



/*
        int j=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval = new Leetcode.Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
        */
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}