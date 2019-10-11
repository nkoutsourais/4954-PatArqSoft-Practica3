package mastermind.models;

import mastermind.utils.Memento;
import java.util.ArrayList;
import java.util.List;

public class GameMemento extends Memento {

    private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

    private int attempts;
    
    public GameMemento() {
        this.results = new ArrayList<>();
        this.proposedCombinations = new ArrayList<>();
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public void setSecretCombination(SecretCombination secretCombination) {
        this.secretCombination = secretCombination;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public Result getResult(int index) {
        return this.results.get(index);
    }
}