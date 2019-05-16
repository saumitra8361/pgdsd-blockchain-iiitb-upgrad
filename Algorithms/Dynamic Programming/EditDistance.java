public class EditDistance {

    /**
     * Returns the EditDistance between source and target string
     * @param source
     * @param target
     * @return
     */
    public int editDistanceBetween(String source, String target) {
        if (source == null || target == null){
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        int sourceLength = source.length();
        int targetLength = target.length();

        Integer[][] E = new Integer[sourceLength+1][targetLength+1];

        for (int i = 0; i <= sourceLength; i++ ){
            E[i][0] = i;
        }
        for (int j = 0; j <= targetLength; j++ ){
            E[0][j] = j;
        }

        for (int i = 1; i <= sourceLength; i++){
            for (int j = 1; j <= targetLength; j++){
                int cost = source.charAt(i - 1) == target.charAt(j - 1) ? 0 : 1;

                E[i][j] = Math.min( Math.min( E[i-1][j-1] + cost, E[i][j-1] + 1), E[i-1][j] + 1);
            }
        }
        return E[sourceLength][targetLength];
    }

    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        System.out.println("EditDistance from mo to on is " +
                editDistance.editDistanceBetween("mo", "on"));
        System.out.println("EditDistance from  Ankita to Nikita is "
                + editDistance.editDistanceBetween("Ankita", "Nikita"));
    }
}

