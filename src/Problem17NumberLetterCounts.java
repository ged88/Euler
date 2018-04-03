// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters
// used in total.
//
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//
//
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
// (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

public class Problem17NumberLetterCounts {

public static String[] ones =
        { "","one","two","three","four","five","six","seven","eight","nine","ten",
        "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

public static String[] tens =
        {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};

public static String[] hundreds =
        {"","onehundred","twohundred","threehundred","fourhundred","fivehundred","sixhundred",
        "sevenhundred","eighthundred","ninehundred"};

    public static void main(String[] args) {
        int[] lengthOnes = new int[20];
        int[] lengthTens = new int[10];
        int[] lengthHundreds = new int[10];

        for (int i=0; i<20;i++) {
            lengthOnes[i]=ones[i].length();
        }
        for (int i=0;i<10;i++) {
            lengthTens[i]=tens[i].length();
            lengthHundreds[i]=hundreds[i].length();
        }

        int result = 0;
        for (int i=1; i<1000;i++) {
            int one;
            if (i%100<20)
                one=i%100;
            else
                one = i%10;

            int ten = ((i%100)-one)/10;
            int hundreds = (i-(i%100))/100;

            if (ten<2) {
                result+=lengthOnes[one];
            } else {
                result+=lengthOnes[one];
                result+=lengthTens[ten];
            }
            if ((i>100) && (i%100!=0)) {
                result+=3; // for AND
                result+=lengthHundreds[hundreds];
            }
        }
        result+=10; //for one thousand

        System.out.println("Aantal characters: " + result);
    }
}
