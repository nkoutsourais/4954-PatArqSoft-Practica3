package mastermind.models.dao.file;

import mastermind.models.SecretCombination;

class SecretCombinationFileDao extends CombinationFileDao {

    public SecretCombinationFileDao(SecretCombination secretCombination) {
        super(secretCombination);
    }

    public SecretCombination getSecretCombination() {
        return (SecretCombination)this.getCombination();
    }
}