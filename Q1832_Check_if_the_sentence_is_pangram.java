import java.util.Arrays;

public class Q1832_Check_if_the_sentence_is_pangram {
    public static void main(String[] args) {
        String sentence = "abhayisdonkey";
        System.out.println(checkIfPangram(sentence));
    }

    static Boolean checkIfPangram(String sentence) {
       for(int i=0; i<26; i++) {
           char currentCharacter = (char)('a' + i);
           if(sentence.indexOf(currentCharacter) == -1) {
               return false;
           }
       }
       return true;
    }
}
