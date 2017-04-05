package Hihocoder;
import java.util.*;
/**
 * Created by cpy on 2017/3/22.
 */
public class trie {
    // IDE中的字符串自动补全
    // 前缀树
    public static void main(String[] args) {
        TrieNode root=new TrieNode('#', null);
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            String word=scanner.next ();
            int wordLength=word.length();
            TrieNode copyRoot=root;
            for(int j=0;j<wordLength;j++){
                char ch=word.charAt(j);

                int k=0;
                int totolChild=copyRoot.childSize();
                for(; k<copyRoot.childSize();k++){
                    if( ch== copyRoot.list.get(k).getValue() ){
                        copyRoot.count++;
                        copyRoot=copyRoot.list.get(k);
                        break;
                    }
                }
                if( k>=totolChild){
                    TrieNode newTrie=new TrieNode(ch, copyRoot);
                    copyRoot.count++;
                    copyRoot.addChild(newTrie);
                    copyRoot=newTrie;
                }
            }
            copyRoot.setEnd();
            copyRoot.count++;
        }
/////////////////////////search
        int m=scanner.nextInt();
        int[] answer=new int[m];
        for(int i=0;i<m;i++){
            String target=scanner.next();
            TrieNode copy=root;
            for(int j=0; j<target.length();j++){
                char c=target.charAt(j);
                int k=0;
                int num=copy.childSize();
                for(; k<copy.childSize();k++){
                    if(c== copy.list.get(k).getValue()){
                        copy=copy.list.get(k);
                        if( j==target.length()-1)
                            answer[i]=copy.count;
                        break;
                    }
                }

                if( k>=num){
                    answer[i]=0;
                    break;
                }
            }
        }
        for (int i=0;i<m;i++)
            System.out.println( answer[i]);


    }
}

class TrieNode {
    char c;
    int count;
    boolean end=false;
    TrieNode parent;
    List<TrieNode> list=new ArrayList<>();
    public TrieNode(char c, TrieNode parent ){
        this.c=c;
        this.parent=parent;
        count=0;
    }
    public void addChild(TrieNode t){
        list.add(t);
    }
    public int childSize(){
        return list.size();
    }
    public char getValue(){return c;}
    public void setEnd(){
        end=true;
    }

}
