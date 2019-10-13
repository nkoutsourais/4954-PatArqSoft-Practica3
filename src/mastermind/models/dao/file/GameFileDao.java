package mastermind.models.dao.file;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mastermind.models.Game;
import mastermind.models.GameMemento;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.SecretCombination;
import mastermind.types.Color;

public class GameFileDao implements FileDao {

    private final Game game;

    GameFileDao(Game game) {
        this.game = game;
    }

    public void save(FileWriter fileWriter) {
        saveAttempts(fileWriter);
        GameMemento gameMemento = this.game.createMemento();
        new SecretCombinationFileDao(gameMemento.getSecretCombination()).save(fileWriter);
        for(int i = 0; i < this.game.getAttempts(); i++)
        {
            new ProposedCombinationFileDao(gameMemento.getProposedCombination(i)).save(fileWriter);
            new ResultFileDao(gameMemento.getResult(i)).save(fileWriter);
        }
    }

    public void load(BufferedReader bufferedReader) {
        GameMemento gameMemento = new GameMemento();
        gameMemento.setAttempts(getAttempts(bufferedReader));
        SecretCombinationFileDao secretCombinationFileDao = new SecretCombinationFileDao(new SecretCombination());
        secretCombinationFileDao.load(bufferedReader);
        gameMemento.setSecretCombination(secretCombinationFileDao.getSecretCombination());
        for(int i = 0; i < gameMemento.getAttempts(); i++)
        {
            ProposedCombinationFileDao proposedCombinationFileDao = new ProposedCombinationFileDao(new ProposedCombination(new ArrayList<Color>()));
            proposedCombinationFileDao.load(bufferedReader);
            gameMemento.addProposedCombination(proposedCombinationFileDao.getProposedCombination());
            ResultFileDao resultFileDao = new ResultFileDao(new Result(0, 0));
            resultFileDao.load(bufferedReader);
            gameMemento.addResult(resultFileDao.getResult());
        }
        this.game.restore(gameMemento);
    }

    private void saveAttempts(FileWriter fileWriter) {
        try {
            fileWriter.write(this.game.getAttempts() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getAttempts(BufferedReader bufferedReader) {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            return 0;
        }
    }
}