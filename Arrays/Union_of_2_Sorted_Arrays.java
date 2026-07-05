class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list=new ArrayList<>();
        int n=a.length, m=b.length;
        
        int i=0, j=0;
        Integer prev=null;
        
        while(i<n && j<m) {
            
            if(a[i]<b[j]) {
                if(prev==null ||a[i]!=prev) {
                    list.add(a[i]);
                    prev=a[i];
                }
                i++;
            }
            else if(a[i]>b[j]) {
                if(prev==null || b[j]!=prev) {
                    list.add(b[j]);
                    prev=b[j];
                }
                j++;
            }
            else {
                if(prev==null || b[j]!=prev) {
                    list.add(b[j]);
                    prev=b[j];
                }
                i++; j++;
            }
        }
        
        while(i<n) {
                if(prev==null ||a[i]!=prev) {
                    list.add(a[i]);
                    prev=a[i];
                }
                i++;
        }
        
        while(j<m) {
                if(prev==null || b[j]!=prev) {
                    list.add(b[j]);
                    prev=b[j];
                }
                j++;
        }
        return list;
    }
}
