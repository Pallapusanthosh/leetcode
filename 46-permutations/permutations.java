import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> sol=new ArrayList<>();
        back(nums,0,sol);
        return sol;
    }
    void back(int[] a,int i,List<List<Integer>> sol){
        if(i==a.length){
            List<Integer> cur=new ArrayList<>(a.length);
            for(int x:a) cur.add(x);
            sol.add(cur);
            return;
        }
        for(int j=i;j<a.length;j++){
            int t=a[i];a[i]=a[j];a[j]=t;
            back(a,i+1,sol);
            t=a[i];a[i]=a[j];a[j]=t;
        }
    }
}
