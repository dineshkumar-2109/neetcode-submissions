
class Solution {
    public String foreignDictionary(String[] words) {
        int inDegree[] = new int[26];
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i) - 'a');
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            
            int c = 0;
            while (c < first.length() && c < second.length()) {
                int firstChar = first.charAt(c);
                int secondChar = second.charAt(c);
                if (firstChar != secondChar) {
                    int u = firstChar - 'a';
                    int v = secondChar - 'a';
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        inDegree[v]++;
                    }
                    break;
                }
                c++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (set.contains(i) && inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int currInd = q.poll();
            sb.append((char) (currInd + 'a'));
            for (int next : adj.get(currInd)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        if (sb.length() < set.size()) {
            return "";
        }
        
        return sb.toString();
    }
}