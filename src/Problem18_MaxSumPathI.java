// By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
//
//3
//7 4
//2 4 6
//8 5 9 3
//
//That is, 3 + 7 + 4 + 9 = 23.
//
//Find the maximum total from top to bottom of the triangle below:
//
//75
//95 64
//17 47 82
//18 35 87 10
//20 04 82 47 65
//19 01 23 75 03 34
//88 02 77 73 07 63 67
//99 65 04 28 06 16 70 92
//41 41 26 56 83 40 80 70 33
//41 48 72 33 47 32 37 16 94 29
//53 71 44 65 25 43 91 52 97 51 14
//70 11 33 28 77 73 17 78 39 68 17 57
//91 71 52 38 17 14 91 43 58 50 27 29 48
//63 66 04 68 89 53 67 30 73 16 69 87 40 31
//04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
//
//NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67,
// is the same challenge with a triangle containing one-hundred rows;
// it cannot be solved by brute force, and requires a clever method! ;o)


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem18_MaxSumPathI {


    public static void main(String[] args) {

        // aantal regels in de file
        int nmbLines = 15;

        // Op iedere regels staat een getal meer dan de vorige.
        // Op de eerste regel 1 getal, op de 2e 2, etc.
        // totaal bevat het totaal aantal cijfers en lengte array

        int totaal = 0;
        for (int i=0; i<=nmbLines; i++){
            totaal += i;
         }

        // Creeer array lang genoeg voor al de cijfers
        int[] result = new int[totaal];

        // read integers from file and store them as integers in array digits
        Scanner file = null;

        try {
            file = new Scanner(new File("C:\\Users\\Reserve Account\\Documents\\GitHub\\Java\\Euler\\src\\getallen2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int nmbCounter = 0;
        while(file.hasNext()){
            if (file.hasNextInt()) {
                result[nmbCounter] = file.nextInt();
                nmbCounter++;
            }
            else file.next();
        }

        //print last line with numbers
        // for(int i=totaal-nmbLines; i<totaal; i++)
        //    System.out.print(digits[i] + " ");

        int startCurrentLine = totaal - nmbLines;
        int startPrevLine;

        for (int currentLine=nmbLines-1; currentLine>0; currentLine--) {
            startPrevLine = startCurrentLine;
            startCurrentLine = startCurrentLine - currentLine;
            for (int j=0; j<currentLine;j++) {
                // kijk welke van de 2 kinderen het grootst is
                if (result[startPrevLine+j]>result[startPrevLine+j+1]) {
                    result[startCurrentLine+j]+=result[startPrevLine+j];
                } else {
                    result[startCurrentLine+j]+=result[startPrevLine+j+1];
                }
            }
        }

        System.out.println(result[0]);
    }
}

/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class IntegersFromFile {

	public static void main(String[] args) {
		Scanner file = null;
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			file = new Scanner(new File("test.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(file.hasNext()){
			if (file.hasNextInt()) list.add(file.nextInt());
			else file.next();
		}

		Collections.sort(list);

		for (Integer i: list) System.out.println(i);

	}

}
 */