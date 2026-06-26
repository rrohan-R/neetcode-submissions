class Twitter {
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    int time;
    
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));

        for(int foloweeId : followMap.getOrDefault(userId, new HashSet<>())){
            feed.addAll(new ArrayList<>(tweetMap.getOrDefault(foloweeId, new ArrayList<>())));
        }

        feed.sort((a,b) -> b[0] - a[0]);

        List<Integer> res = new ArrayList<>();

        for(int i=0; i<Math.min(10, feed.size()); i++){
            res.add(feed.get(i)[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
