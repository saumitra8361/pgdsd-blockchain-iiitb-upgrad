import java.io.File;

public class FileFinder {
    /**
     * Recursively finds all the files of given fileName present in the input path
     *
     * @param fileName
     * @param inputPath
     */
    public void findFile(String fileName, String inputPath) {
        File directory = new File(inputPath);
        if (directory.isDirectory()) {
            File[] list = directory.listFiles();
            for (File file : list) {
                if (file.isDirectory()) {
                    findFile(fileName, file.getAbsolutePath());
                } else if (fileName.equals(file.getName())) {
                    System.out.println(inputPath + "/" + fileName + "found");
                }
            }
        }
    }

    public static void main(String args[]) {
        String projectPath = System.getProperty("user.dir");
        FileFinder fileFinder = new FileFinder();
        fileFinder.findFile("Algorithms.iml", projectPath);
    }
}
