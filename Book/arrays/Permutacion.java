package arrays;

import java.util.Map;
import java.util.HashMap;

public class Permutacion {

    public static void main(String[] args) {
        Permutacion p = new Permutacion();
        System.out.println("[abcaaabbb][cba]: " + p.isPermutation("abcaaabbb", "cba"));
        System.out.println("[efg][cba]: " + p.isPermutation("efg", "cba"));
        System.out.println("[aabbcc][aaabc]: " + p.isPermutation("aabbcc", "aaabc"));
    }

    public boolean isPermutation(String s1, String s2) {
        
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return false;
        if(s1.length() > s2.length()) {
            Map<Character, Integer> charMap = countCharacters(s1);
            return isPermutation(charMap, s2);
        } else {
            Map<Character, Integer> charMap = countCharacters(s2);
            return isPermutation(charMap, s1);
        }
  
    }

    protected boolean isPermutation(Map<Character,Integer> charMap, String s) {
        boolean ret = true;

        for(int i = 0; i < s.length() && ret ; i++) {
            Character c = s.charAt(i);
            if(charMap.containsKey(c)) {
                Integer count = charMap.get(c) - 1;
                ret = count >= 0;
                charMap.put(c, count); 
            } else {
                ret = false;
            }
        }

        return ret;
    }

    protected Map<Character, Integer> countCharacters (String s) {
        Map<Character, Integer> ret = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(ret.containsKey(c)) {
                ret.put(c, ret.get(c) +1);
            } else {
                ret.put(c, 1);
            }
        }

        return ret;
    }
}