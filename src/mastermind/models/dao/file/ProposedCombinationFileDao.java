package mastermind.models.dao.file;

import mastermind.models.ProposedCombination;

class ProposedCombinationFileDao extends CombinationFileDao {

    public ProposedCombinationFileDao(ProposedCombination secretCombination) {
        super(secretCombination);
    }

    public ProposedCombination getProposedCombination() {
        return (ProposedCombination)this.getCombination();
    }
}