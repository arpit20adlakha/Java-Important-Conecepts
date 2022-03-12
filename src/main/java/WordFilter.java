import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class WordFilter {
    TrieNode prefixTrie;
    TrieNode suffixTrie;

    public WordFilter(String[] words) {
        this.prefixTrie = new TrieNode();
        this.suffixTrie = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            insert(word, prefixTrie, 0, word.length, 1, i);
            insert(word, suffixTrie, word.length - 1, -1, -1, i);
        }

    }

    public int f(String prefix, String suffix) {
        List<Integer> prefixIndexes = retrieve(prefix, prefixTrie);
        List<Integer> suffixIndexes = retrieve(suffix, suffixTrie);
        List<Integer> list = prefixIndexes
                .stream()
                .filter(suffixIndexes::contains)
                .collect(Collectors.toList());

        Collections.sort(list, Collections.reverseOrder());

        if (list.size() == 0) {
            return -1;
        }
        return list.get(0);
    }

    private void insert(char[] word, TrieNode node, int start, int end, int step, int wordIndex) {
        for (int i = start; i != end; i += step) {
            int value = word[i] - 'a';
            if (node.children[value] == null) {
                node.children[value] = new TrieNode();
            }
            node = node.children[value];
            node.indexes.add(wordIndex);
        }
    }

    private List<Integer> retrieve(String str, TrieNode node) {
        for(int i = 0; i< str.length(); i++) {
            node = node.children[str.charAt(i) - 'a'];
        }
        if (node == null) {
            return null;
        }
        return node.indexes;
    }
    public static void main(String[] args) {
        WordFilter obj  = new WordFilter(new String[]{"apple"});
        obj.f("a", "e");
    }
}




class TrieNode {
    TrieNode[] children = new TrieNode[26];
    List<Integer> indexes = new ArrayList();
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
