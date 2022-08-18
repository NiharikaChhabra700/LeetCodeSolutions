class Solution {
public:
    
        static bool compare(const string &word1, const string &word2) {
        return word1.length() < word2.length();
    }

    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), compare);
        unordered_map<string, int> map;
        int ans = 0;
        for (string word : words) {
            for (int i = 0; i < word.length(); i++) {
                string predecessor  = word.substr(0, i) + word.substr(i + 1);
                map[word] = max(map[word], map.find(predecessor) == map.end() ? 1 : map[predecessor] + 1);
            }
            ans = max(ans, map[word]);
        }
        return ans;
    } 
    
};