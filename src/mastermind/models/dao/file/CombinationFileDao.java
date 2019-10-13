package mastermind.models.dao.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import mastermind.models.*;
import mastermind.types.Color;

abstract class CombinationFileDao implements FileDao {

    private final Combination combination;

    protected CombinationFileDao(Combination combination) {
        this.combination = combination;
    }

    public void save(FileWriter fileWriter) {
        try {
            for (Color color : combination.getColors()) {
                fileWriter.write(color.ordinal() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            List<Color> colors = new ArrayList<>();
            for(int i = 0; i < Combination.getWidth(); i++)
                colors.add(Color.values()[Integer.parseInt(bufferedReader.readLine())]);
            this.combination.setColors(colors);
        } catch (IOException e) {
        }
    }

    protected Combination getCombination() {
        return this.combination;
    }
}