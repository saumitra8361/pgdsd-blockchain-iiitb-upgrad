package com.company;

import java.util.Scanner;

public class Chemistry {
    public static void main(String args[]) {
        String[] elements = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
                "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
                "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W",
                "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np",
                "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg",
                "Cn", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo" };

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String inputWord = myScanner.next();
        String chemWord = spellWord(inputWord, elements);

        System.out.println(chemWord);

        myScanner.close();
    }

    /**
     * @param word the word that we want to re-spell using abbreviations of elements in the periodic table
     * @param elements an array that contains the abbreviations of elements in the periodic table
     *
     * @return word re-spelled using abbreviations of elements in the periodic table
     *
     * The spellWord function will take in two parameters, word and elements.
     * 1. Word represents the word that we want to re-spell using abbreviation of the elements from
     * the periodic table.
     * 2. Elements represents possible element abbreviations that you can use to re-spell the word
     *
     * The function needs to return a String representing the word that you have re-spelled
     * using abbreviations of the elements in the periodic table.
     *
     */
    public static String spellWord(String word, String[] elements) {
        // write your code here to spell word with element abbreviations
        String[] array = word.split("");
/*        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
*/
        for(int i=0; i<array.length; i++){
            // System.out.print(wordString[i]+" ");
            for(int j=0;j<elements.length;j++){
                if((elements[j].length() == 1) && (array[i].compareToIgnoreCase(elements[j]) == 0)){
                    System.out.print(elements[j]+" ");
                }
            }
        }
        return word;
    }

    // feel free to write additional helper functions below
}