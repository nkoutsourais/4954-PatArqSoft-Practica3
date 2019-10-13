package mastermind.models.dao.file;

import java.io.BufferedReader;
import java.io.FileWriter;

interface FileDao {

    void save(FileWriter fileWriter);

    void load(BufferedReader bufferedReader);
}