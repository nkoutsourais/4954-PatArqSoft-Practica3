package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.models.dao.DaoType;

public class MastermindServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicImplementationServer logicServer;

    private MastermindServer(DaoType daoType) {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicImplementationServer(daoType);
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        DaoType daoType = DaoType.FILE;
        if(args.length > 0 && args[0] != null)
            daoType = DaoType.parser(args[0]);
        new MastermindServer(daoType).serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }
}