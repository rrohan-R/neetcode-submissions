class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        for(int i : stones){
            list.add(i);
        }

        while(list.size() > 1){
            Collections.sort(list);

            int smash = (list.remove(list.size() - 1)) - (list.remove(list.size() - 1));
            if(smash != 0){
                list.add(smash);
            }
        }

        return list.isEmpty() ? 0 : list.get(0);
    }
}
