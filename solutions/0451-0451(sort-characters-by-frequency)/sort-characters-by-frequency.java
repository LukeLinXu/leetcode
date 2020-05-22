// Given a string, sort it in decreasing order based on the frequency of characters.
//
// Example 1:
//
// Input:
// "tree"
//
// Output:
// "eert"
//
// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//
//
//
// Example 2:
//
// Input:
// "cccaaa"
//
// Output:
// "cccaaa"
//
// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
//
//
//
// Example 3:
//
// Input:
// "Aabb"
//
// Output:
// "bbAa"
//
// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
//
//


class Solution {
    /**
     * 直接
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        class Info{
            char c;
            int count;
            public Info(char c, int count){
                this.c = c;
                this.count = count;
            }
        }
        ArrayList<Info> list = new ArrayList<>(map.size());
        for(char c: map.keySet()){
            list.add(new Info(c, map.get(c)));
        }
        list.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.count - o1.count;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Info info: list){
            int count = info.count;
            while (count > 0){
                sb.append(info.c);
                count--;
            }
        }
        return sb.toString();
    }
}
