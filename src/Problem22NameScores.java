// Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
// begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
// multiply this value by its alphabetical position in the list to obtain a name score.
//
//For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
// is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//
//What is the total of all the name scores in the file?


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem22NameScores {

    public static void main (String[] args){
        // (1) read file into array
        // (2) sort array
        // (3) calculate score per name
        // (4) calculate result

        ArrayList<String> names = new ArrayList<>();

        File f = new File("C:\\Users\\Reserve Account\\Documents\\GitHub\\Java\\Euler\\src\\names.txt");

        try {
            Scanner s = new Scanner(f);
            String delimiter = "\",\"";
            s.useDelimiter(delimiter);

            while (s.hasNext()) {
                names.add(s.next());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error "+ ex);
        }
        catch (Exception ex)
        {
            System.out.println("Error "+ ex);
        }


        int nmbNames = names.size();
        // Fix firts element nd last element as they have a leading of closing quote
        names.set(0,names.get(0).substring(1));
        names.set(nmbNames-1,names.get(nmbNames-1).substring(0,names.get(nmbNames-1).length()-1));
        System.out.println(names.get(0));
        System.out.println(names.get(nmbNames-1));

        Collections.sort(names);

        int result=0;

        for (int i=0; i<names.size();i++) {
            int nameValue = 0;
            for (int j=0; j<names.get(i).length();j++){
                nameValue += Character.getNumericValue(names.get(i).charAt(j))-9;
            }
            result += (i+1)*nameValue;

        }

        System.out.println(names.get(0));
        System.out.println(names.get(nmbNames-1));
        System.out.println(Character.getNumericValue('A'));
        System.out.println("Totaal: " + result);


    }

}
