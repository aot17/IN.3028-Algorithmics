package ch.unifr.algo2023.students.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {

    private String filePath;
    private File fileObject;

    public static void main(String[] args) {
        //How to use it:
        SimpleFileWriter writer = new SimpleFileWriter("src/ch/unifr/algo2023/students/tools/filewriter.txt");
        writer.overwrite("Overwrite a file.\n");
        writer.append("Append to a file.\n");
    }

    /**
     * Creates a new file if the file given in the filePath does not exist on conustrction
     *
     * @param filePath the path to the file
     */
    public SimpleFileWriter(String filePath) {
        this.filePath = filePath;
        this.loadFile();
        this.createFile(); // creates the file only if it doesn't exist
    }

    /**
     * append to file the given text
     *
     * @param text the text to append
     */
    public void append(String text) {
        this.write(text, true);
    }

    /**
     * Overwrites files
     *
     * @param text the text to put into the file
     */
    public void overwrite(String text) {
        this.write(text, false);
    }


    private void loadFile() {
        try {
            this.fileObject = new File(this.filePath);
        } catch (Exception e) {
            System.out.println("An error occurred, the file could not be loaded.");
            e.printStackTrace();
        }
    }

    private void createFile() {
        try {
            this.fileObject.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred, the file could not be created.");
            e.printStackTrace();
        }
    }

    private void write(String text, Boolean append) {
        try {
            FileWriter fw = new FileWriter(this.filePath, append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred, couldn't write to file.");
            e.printStackTrace();
        }
    }
}
