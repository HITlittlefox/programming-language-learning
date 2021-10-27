package test;

public class StringEditor {
    public static String removeNonLetters(String original) {
        StringBuffer aBuffer = new StringBuffer(original.length());
        char aCharacter;

        for (int i = 0; i < original.length(); i++) {
            aCharacter = original.charAt(i);
            if (Character.isLetter(aCharacter))
                aBuffer.append(new Character(aCharacter));
        }
        return new String(aBuffer);
    }

    public static void main(String[] args) {
        String original = "Hello123, My Name is Mark, 234I think you are my classmate?!!";
        System.out.println
                (StringEditor.removeNonLetters(original));
    }

}


