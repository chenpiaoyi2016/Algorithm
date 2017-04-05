package Hihocoder;
import java.util.*;

public class LCA_path {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Map<String,TreeNode> map=new HashMap<>();
        for( int i=0;i<n;i++){      // 读入
            String father=scanner.next();
            String son=scanner.next();
            if(!map.containsKey( father) ){
                TreeNode fatherNode=new TreeNode(father);
                map.put(father, fatherNode);
            }
            if( !map.containsKey(son)){
                TreeNode sonNode=new TreeNode(son);
                sonNode.father= map.get(father);
                map.put(son, sonNode);
            }
        }

        int m= scanner.nextInt();
        for( int i=0;i<m;i++){
            String name1=scanner.next();
            String name2=scanner.next();

            TreeNode t1=map.get(name1);
            TreeNode t2=map.get(name2);
            if( name1.equals(name2)&& t1==null &&t2==null){ // ????
                System.out.println(name1);
                continue;
            }


            TreeNode ancestor1=t1, ancestor2=t2;
            //没有指向son的引用 采用计数
            int i1=0,i2=0;
            while(ancestor1 !=null) {
                ancestor1 = ancestor1.father;
                i1++;
            }
            while (ancestor2 !=null) {
                ancestor2 = ancestor2.father;
                i2++;
            }
            if( i2>i1) {
                ancestor2 = t1;
                ancestor1 = t2;
            }else {
                ancestor2 = t2;
                ancestor1 = t1;
            }
            int diff=Math.abs(i1-i2);
            while( diff-- > 0)
                ancestor1=ancestor1.father;

            while( ancestor1!=null && ancestor2!=null && !ancestor1.name.equals(ancestor2.name)  ){
                //重要的警示。。。。。判断null在前面 不然会出现noPointerException
                ancestor1=ancestor1.father;
                ancestor2=ancestor2.father;
            }

            if( ancestor1!=null && ancestor2!=null )
                System.out.println(ancestor1.name);
            else
                System.out.println("-1");

        }
        scanner.close();
    }
}

class TreeNode{
    String name;
    TreeNode father;
    public TreeNode(String name) {
        this.name=name;
    }
}


