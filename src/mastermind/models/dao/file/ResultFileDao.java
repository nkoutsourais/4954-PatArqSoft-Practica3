package mastermind.models.dao.file;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Result;

class ResultFileDao implements FileDao {

    private Result result;

    public ResultFileDao(Result result) {
        this.result = result;
    }

    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(this.result.getBlacks() + "\n");
            fileWriter.write(this.result.getWhites() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            int blacks = Integer.parseInt(bufferedReader.readLine());
            int whites = Integer.parseInt(bufferedReader.readLine());
            this.result = new Result(blacks, whites);
        } catch (IOException e) {
        }
    }

    public Result getResult() {
        return this.result;
    }
}