import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class deleteFiles {

    static ArrayList<String> arrayOfFailedPathsDeleted = new ArrayList<>();
    static int numOfDeletedFiles = 0;
    static int numOfNonDeletedFiles = 0;

    public static void deleteFiles(File[] customersDirectory)
    {
        try {
            // Traversing through the files array
            for (File filename : customersDirectory) {
                // If a sub directory is found,
                if (filename.isDirectory()) {

                    Path test = filename.toPath();
                    File projectDirectory[] = new File(test.toString()).listFiles();


                    for (File project : projectDirectory) {
                        if (project.isDirectory()) {
                            System.out.println(project.getName());

                            if (project.getName().equals("2022")) {
                                System.out.println("Deleting 2022 in");
                                System.out.println(project.getPath());
                                if (!project.delete()) {
                                    numOfNonDeletedFiles++;
                                    System.out.println("ERROR!!");
                                    System.out.println(project.getPath() + "did not delete");
                                    arrayOfFailedPathsDeleted.add(project.getPath());

                                } else numOfDeletedFiles++;
                            }

                            if (project.getName().equals("2023")) {
                                System.out.println("deleting 2023");
                                System.out.println(project.getPath());
                                if (!project.delete()) {
                                    numOfNonDeletedFiles++;
                                    System.out.println("ERROR!!");
                                    System.out.println(project.getPath() + "did not delete");
                                    arrayOfFailedPathsDeleted.add(project.getPath());

                                } else numOfDeletedFiles++;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        File failedDeletesPath = new File("Files that failed to delete.txt");
        failedDeletesPath.createNewFile();
        FileWriter fileWriter = new FileWriter(failedDeletesPath, true); //true will not allow overwriting, but will have the new text at the end.

        Path path = FileSystems.getDefault().getPath(".").toAbsolutePath(); //Find current working directory
        File file[] = new File(path.toString()).listFiles();
        deleteFiles(file);

        System.out.println("Number of deleted folders: " + numOfDeletedFiles);
        System.out.println("Number of deletes folders failed: " + numOfNonDeletedFiles);


        for (String filePath: arrayOfFailedPathsDeleted) {
            System.out.println("File failed: " + filePath);
            fileWriter.write(filePath + "\n");
        }

        fileWriter.close();

    }

}
