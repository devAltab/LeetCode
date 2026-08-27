class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        getAllCombinations(digits, 0, "", map, ans);

        return ans;
    }

    public void getAllCombinations(
        String digits,
        int index,
        String current,
        HashMap<Character, String> map,
        List<String> ans) {

        // Base case
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = map.get(digits.charAt(index));

        // Try every letter
        for (char ch : letters.toCharArray()) {

            getAllCombinations(
                digits,
                index + 1,
                current + ch,
                map,
                ans
            );
        }
    }
}