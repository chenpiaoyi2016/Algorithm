/**
 * Created by cpy on 2016/11/1.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min= Integer.MAX_VALUE,max=0;
        for( int i=0; i<prices.length; i++){
            min=Math.min( min, prices[i]);
            max= Math.max( max, prices[i]-min);
        }
        return max;

    }
}
