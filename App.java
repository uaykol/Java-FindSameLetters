package project;

import java.util.Scanner;

public class App {
    public static void main(String [] args)
    {

        Scanner kb = new Scanner(System.in);

        System.out.println("Please enter the first string : ");
        String str1 = kb.nextLine();

        System.out.println("Please enter the second string : ");
        String str2 = kb.nextLine();

        System.out.println("Similar letters of these 2 strings = ");

        char [] similarLetters = StringUtil.Tr_findSameLettersOfTheStrings(str1, str2).toCharArray();

        for(int i = 0; i < similarLetters.length; i++)
                System.out.println(similarLetters[i]);

    }
}

class StringUtil
{

    // also we can use ascii order for English letters but for Turkish letters its not possible
    private static String tr_Alphabet = "abcçdefgğhıijklmnoöprsştuüvyz";
    private static String tr_Upper_Case_Alphabet = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";


    public static String Tr_findSameLettersOfTheStrings(String str1, String str2)
    {

        int lengthOfStr1 = str1.length();
        int lengthOfStr2 = str2.length();

        char [] similarLetters;
        char [] tr_CharAlphabet = tr_Alphabet.toCharArray();
        char [] tr_CharAlphabetUpper = tr_Upper_Case_Alphabet.toCharArray();

        boolean [] char1_Lower_Case = getBooleanCharArray(str1, tr_CharAlphabet);
        boolean [] char2_Lower_Case = getBooleanCharArray(str2, tr_CharAlphabet);
        boolean [] char1_Upper_Case = getBooleanCharArray(str1, tr_CharAlphabetUpper);
        boolean [] char2_Upper_Case = getBooleanCharArray(str2, tr_CharAlphabetUpper);

        //Maximum similarity can be length of the shortest string
        if(lengthOfStr1 < lengthOfStr2)
            similarLetters = new char[lengthOfStr1];
        else
            similarLetters = new char[lengthOfStr2];

        int order = 0;

        for(int i = 0; i < tr_Alphabet.length(); i++)
        {
            if(char1_Lower_Case[i] == true && char2_Lower_Case[i] == true)
            {
                similarLetters[order] = tr_CharAlphabet[i];
                order++;
            }
            else if(char1_Upper_Case[i] == true && char2_Upper_Case[i] == true)
            {
                similarLetters[order] = tr_CharAlphabetUpper[i];
                order++;
            }
        }

        return new String(similarLetters).trim();

    }


    public static boolean [] getBooleanCharArray(String string, char [] alphabet)
    {

        char [] charArrayOfTheString = string.toCharArray();

        //default value of booleans are false
        boolean [] stringToBoolean = new boolean[alphabet.length];


        for(int i = 0; i < alphabet.length; i++)
        {
            for(char character: charArrayOfTheString)
            {
                if(alphabet[i] == character && stringToBoolean[i] != true)
                {
                    stringToBoolean[i] = true;
                    break;
                }
            }
        }

        //To Reduce Complexity We Need to Use This Code Instead of the Top One
        //But I Didn't use because of String methods not allowed
        /*
        for(int i = 0; i < alphabet.length; i++) {
            if ((string.indexOf(alphabet[i]) >= 0) && stringToBoolean[i] != true) {
                stringToBoolean[i] = true;
            }
        }
        */


        return stringToBoolean;
    }

}
