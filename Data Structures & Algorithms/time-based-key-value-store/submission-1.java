class TimeMap{
    private Map<String,List<Pair>> map;
    private static class Pair{
        String value;
        int timestamp;

        Pair(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    public TimeMap(){
        map=new HashMap<>();
    }
    public void set(String key,String value,int timestamp){
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));
    }
    public String get(String key,int timestamp){
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list=map.get(key);
        int l=0,r=list.size()-1;
        String result="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid).timestamp<=timestamp){
                result=list.get(mid).value;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return result;
    }
}