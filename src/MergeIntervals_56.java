import java.util.Collections;
import java.util.Comparator;
import java.util.*;

/**
 * Created by cpy on 2017/2/24.
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1 ) return intervals;
        //intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        List<Interval> res=new LinkedList();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(Interval i:intervals){
            if(i.start<=end )  end=Math.max(end, i.end);
            else{
                res.add(  new Interval(start, end));
                start=i.start; end=i.end;

            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
