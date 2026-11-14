class Twitter {
    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId,int time){
            this.tweetId=tweetId;
            this.time=time;
        }
    } 
    private Map<Integer,Set<Integer>> following;
    private Map<Integer,Tweet> tweets;
    private int time;

    public Twitter() {
        following=new HashMap<>();
        tweets=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet=new Tweet(tweetId,time++);
        newTweet.next=tweets.get(userId);
        tweets.put(userId,newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();

        PriorityQueue<Tweet> maxHeap=new PriorityQueue<>((a,b)->b.time-a.time);

        //Include user's own tweets
        if(tweets.containsKey(userId)){
            maxHeap.offer(tweets.get(userId));
        }
        //Include the latest tweets of each followed user
        for(int followee:following.getOrDefault(userId,new HashSet<>())){
            if(tweets.containsKey(followee)){
                maxHeap.offer(tweets.get(followee));
            }
        }
        //Get at most 10 most recent tweets
        while(!maxHeap.isEmpty() && res.size()<10){
            Tweet curr=maxHeap.poll();
            res.add(curr.tweetId);

            if(curr.next!=null){
                maxHeap.offer(curr.next);
            }
        }
        return res;
    }
    
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId,new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId,new HashSet<>()).remove(followeeId);
    }
}
