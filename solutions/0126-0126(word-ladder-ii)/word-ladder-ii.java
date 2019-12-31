// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
//
// 	Only one letter can be changed at a time
// 	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//
//
// Note:
//
//
// 	Return an empty list if there is no such transformation sequence.
// 	All words have the same length.
// 	All words contain only lowercase alphabetic characters.
// 	You may assume no duplicates in the word list.
// 	You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]
//
// Output:
// [
//   ["hit","hot","dot","dog","cog"],
//   ["hit","hot","lot","log","cog"]
// ]
//
//
// Example 2:
//
//
// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
//
// Output: []
//
// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//
//
//
//
//


public class Solution {


    Map<String, List<String>> map;
    List<List<String>> results;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<List<String>>();
        if(wordList.size() == 0){
            return results;
        }
        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);

        map = new HashMap<String, List<String>>();

        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for(String s : wordList){
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);

        while(!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if(step > min) break;
            for(int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for(char j = 'a'; j <= 'z'; j++){
                    builder.setCharAt(i, j);
                    String new_word = builder.toString();
                    if(ladder.containsKey(new_word)){
                        if(step > ladder.get(new_word)){
                            continue;
                        }else if(step < ladder.get(new_word)){
                            ladder.put(new_word, step);
                            queue.add(new_word);
                        }

                        if(map.containsKey(new_word)){
                            map.get(new_word).add(word);
                        }else{
                            ArrayList<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(new_word, list);
                        }

                        if(new_word.equals(endWord)){
                            min = step;
                        }
                    }
                }
            }
        }
        ArrayList<String> temp = new ArrayList<String>();
        backTrace(endWord, beginWord, temp);
        return results;
    }

    private void backTrace(String word, String start, List<String> temp){
        if(word.equals(start)){
            temp.add(0, start);
            results.add(new ArrayList<String>(temp));
            temp.remove(0);
            return;
        }
        temp.add(0, word);
        if(map.get(word) != null){
            for(String s : map.get(word)){
                backTrace(s, start, temp);
            }
        }
        temp.remove(0);
    }

}
