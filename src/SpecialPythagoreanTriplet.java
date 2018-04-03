public class SpecialPythagoreanTriplet {
    // A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    //
    //a2 + b2 = c2
    //For example, 32 + 42 = 9 + 16 = 25 = 52.
    //
    //There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    //Find the product abc.

    public static void main(String[] args) {
        double cDbl;
        int cInt;
        int c;
        int maxNmb = 1000;
        for (int a=1;a<maxNmb;a++){
            for (int b=a+1;b<maxNmb;b++){
                c=maxNmb-a-b;
                if ((c*c)==((a*a)+(b*b))) {
                    System.out.println(a+ " + " +b+ " + " +c);
                }

                /*cDbl=Math.hypot(a,b);

                cInt=(int)Math.round(cDbl);
                if ((cDbl-cInt)==0) {
                    if ((a+b+cInt)==1000) {
                        System.out.println(a + " + " + b + " + " + cInt);
                        System.out.println(a*b*cInt);
                    }
                }*/
            }
        }
    }
}
