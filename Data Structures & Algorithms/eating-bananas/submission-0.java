class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;
        while(true){
            long totalTime = 0;
            for(int i=0; i<piles.length; i++){
            totalTime += (int) Math.ceil((double)piles[i] / speed);
            }
            if(totalTime <= h){
                return speed;
            }
            speed++;
        }
    }
}
