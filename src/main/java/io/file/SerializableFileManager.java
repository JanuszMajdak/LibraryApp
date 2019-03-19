package io.file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import data.Library;
import exception.DataExportException;
import exception.DataImportException;

import java.io.*;

public class SerializableFileManager implements FileManager {

    private final static String FILE_NAME = "Library.o";


    @Override
    public Library importData() {

        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Lack of file " + FILE_NAME);

        } catch (IOException e) {
            throw new DataImportException("Error of reading the file " + FILE_NAME);

        } catch (ClassNotFoundException e) {
            throw new DataImportException("Not correct type of data in the file " + FILE_NAME);

        }


    }

    @Override
    public void exportData(Library library) {


        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Lack of file " + FILE_NAME);

        } catch (IOException e) {
            throw new DataExportException("Error of saving data to the file " + FILE_NAME);

        }
    }


}
