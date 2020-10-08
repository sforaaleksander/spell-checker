package com.codecool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println(new BetterStringHasher().hash("ABACUS"));
//        60389 339471931
        System.out.println(getHash("DIGITALLY"));
//        21143 abacus
        // DIGITALLY
    }

    private static int getHash(String s){
        int hashcode = new BetterStringHasher().hash(s);
        return Math.abs(hashcode % 72466);
    }
}
