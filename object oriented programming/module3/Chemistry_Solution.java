import java.util.Scanner;

class Chemistry {
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
   * @param word - the word that we want to re-spell using abbreviations of elements in the periodic table
   * @param elements - an array that contains the abbreviations of elements in the periodic table
   * 
   * @return word re-spelled using abbreviations of elements in the periodic table
   * 
   * The spellWord function will take in two parameters, word and elements.
   * 1. The parameter 'word' represents the word that we want to re-spell using an abbreviation of the elements from
   * the periodic table.
   * 2. The parameter 'elements' represents possible element abbreviations that you can use to re-spell the word.
   * 
   * The function needs to return a String representing the word that you have re-spelled
   * using abbreviations of the elements in the periodic table.
   * 
   */
  public static String spellWord(String word, String[] elements) {
    String punctuatedWord = "";
    int index;
    int i = 0;

    while (i < word.length()) {
      if (((i + 2) < word.length()) && (index = searchInElementSymbol(word.substring(i, i + 2), elements)) != -1) {
        punctuatedWord = punctuatedWord.concat(elements[index]);
        i = i + 2;
      } else {
        punctuatedWord = punctuatedWord.concat((word.substring(i, i + 1)).toUpperCase());
        i = i + 1;
      }
    }
    System.out.println(punctuatedWord);
    return punctuatedWord;
  }

  private static int searchInElementSymbol(String element, String[] elements) {
    for (int i = 0; i < elements.length; i++) {
      if (elements[i].equalsIgnoreCase(element)) {
        return i;
      }
    }
    return -1;
  }
}