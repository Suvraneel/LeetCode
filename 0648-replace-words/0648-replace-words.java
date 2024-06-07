class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sent = sentence.split(" ");
        dictionary.sort(Comparator.comparingInt(String::length));
        for(String word: dictionary){
            for(int i=0; i<sent.length; i++){
                if(sent[i].startsWith(word))
                    sent[i] = word;
            }
        }
        return String.join(" ", sent);
    }
}