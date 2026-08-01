class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int card = pq.peek();

            for(int i=card; i<card+groupSize; i++){
                if(!map.containsKey(i)){
                    return false;
                }

                map.put(i, map.get(i) - 1);

                if(map.get(i) == 0){
                    
                    if(i != pq.peek()){
                        return false;
                }

                    map.remove(i);
                    pq.poll();
                }

                
            }
        }

        return true;
    }
}
