//Graph + BFS shortest path
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set=new HashSet<>(wordList);
        //end word must exist in the word list
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);

        int step=1;
        //mark beginWord as visited
        set.remove(beginWord);

        while(!q.isEmpty()){
            int size=q.size();
            //process one bfs level
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return step;
                }

                char[] chars=word.toCharArray();
                //change each character position
                for(int j=0;j<chars.length;j++){
                    char original=chars[j];
                    for(char c='a';c<='z';c++){
                        if(c==original){
                            continue;
                        }
                        chars[j]=c;
                        String newWord=new String(chars);
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    //Restore original character
                    chars[j]=original;
                }
            }
            step++;
        }
        return 0;
    }
}
