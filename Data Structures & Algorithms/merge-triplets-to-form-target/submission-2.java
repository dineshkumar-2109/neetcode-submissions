class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x=false,y=false,z=false;
        for(int tri[]:triplets){
            if(tri[0]>target[0]||tri[1]>target[1]||tri[2]>target[2]){
                continue;
            }
            x|=(tri[0]==target[0]);
            y|=(tri[1]==target[1]);
            z|=(tri[2]==target[2]);
            if (x && y && z) {
                return true;
            }
        }
        return false;
    }
}
