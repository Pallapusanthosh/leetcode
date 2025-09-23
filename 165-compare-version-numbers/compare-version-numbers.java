class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2=  version2.split("\\.");
     
        int n = ver1.length < ver2.length ? ver1.length : ver2.length;
        for(int i = 0 ; i<n;i++){
            String s1 =trim(ver1[i]);
            String s2 =trim(ver2[i]);
            // System.out.println(s1 + s2);
            if(s1.length() != s2.length()){
                return s1.length() > s2.length() ? 1 : -1;
            }

            int val = s1.compareTo(s2);
            if(val!=0){
                return val < 0 ? -1 : 1;
            }
        }
        if(n== ver2.length){
            int i = ver2.length;
            for(int j = i ; j<ver1.length ; j++){
                if(!("0".equals(trim(ver1[j])))){
                    return 1;
                }
            }
        }
        else{
            int i = ver1.length;
            for(int j = i ; j<ver2.length ; j++){
                if(!("0".equals(trim(ver2[j])))){
                    return -1;
                }
            }
        }
        return 0;
    }
    String trim(String s) {
     return s.replaceFirst("^0+(?!$)", "");
    }
}