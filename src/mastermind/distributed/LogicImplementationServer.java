package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.distributed.dispatchers.*;
import mastermind.models.dao.DaoType;

public class LogicImplementationServer extends LogicImplementation {

    public LogicImplementationServer(DaoType daoType) {
        super(daoType);
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.PROPOSE, new ProposeDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new AttemptDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_BLAKS, new BlackDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_COLORS, new ColorDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_WHITES, new WhiteDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_WINNER, new WinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_LOOSER, new LooserDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVENAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GETTITLE, new GetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SETTITLE, new SetTitleDispatcher(this.saveControllerImplementation));
    }
}
