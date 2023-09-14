import java.io.File;
import java.nio.file.Path;
import java.nio.file.FileSystems;

public class deleteFiles {

    public static void delteFiles(File[] customersDirectory, int numOfNonDeletedFiles)
    {
        // Traversing through the files array
        for (File filename : customersDirectory) {
            // If a sub directory is found,
            if (filename.isDirectory()) {

                Path test = filename.toPath();
                File projectDirectory[] = new File(test.toString()).listFiles();


                for (File project: projectDirectory) {
                    if (project.isDirectory()) {
                        System.out.println(project.getName());

                        if (project.getName().equals("2022")) {
                            System.out.println("Deleting 2022 in");
                            System.out.println(project.getPath());
                            project.delete();
                        }

                        if (project.getName().equals("2023")) {
                            System.out.println("deleting 2023");
                            System.out.println(project.getPath());
                            project.delete();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int numOfNonDeletedFiles = 0;
        Path path = FileSystems.getDefault().getPath(".").toAbsolutePath(); //Find current working directory
        File file[] = new File(path.toString()).listFiles();
        delteFiles(file);


    }

}
