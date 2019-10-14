## 4954-PatArqSoft-Practica3
### Practica 3
* Fecha de entrega: 15/10/2019
* Integrantes:
  * Neo Koutsourais

   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="">
</p>

### PlantUML
 
 ```PlantUML
@startuml

package mastermind {
abstract class Mastermind {
}

class MastermindStandalone {
}

Mastermind <|-down- MastermindStandalone
}

package mastermind.controllers {
abstract class AcceptorController {
}
AcceptorController ..> ControllersVisitor
abstract class Controller {
}
Controller <|-down- AcceptorController

interface ControllersVisitor {
}

abstract class Logic {
}

abstract class PlayController {
}

class ProposalController {
}

class RedoController {
}

abstract class ResumeController {
}

abstract class SaveController {
}

abstract class StartController {
}

class UndoController {
}

AcceptorController <|-down- PlayController
AcceptorController <|-down- ResumeController
AcceptorController <|-down- SaveController
AcceptorController <|-down- StartController
Controller <|-down- ProposalController
Controller <|-down- RedoController
Controller <|-down- UndoController

package mastermind.controllers.implementation {
class LogicImplementation {
}

class PlayControllerImplementation {
}

class ResumeControllerImplementation {
}

class SaveControllerImplementation {
}

class StartControllerImplementation {
}
}

PlayController <|-down- PlayControllerImplementation
ResumeController <|-down- ResumeControllerImplementation
SaveController <|-down- SaveControllerImplementation
StartController <|-down- StartControllerImplementation
PlayControllerImplementation *--> ProposalController
PlayControllerImplementation *--> UndoController
PlayControllerImplementation *--> RedoController
Logic <|-down- LogicImplementation
Logic *--> StartControllerImplementation
Logic *--> PlayControllerImplementation
Logic *--> SaveControllerImplementation
Logic *--> ResumeControllerImplementation

}

Mastermind *-down-> Logic

package mastermind.distributed {

class LogicImplementationServer {
}
class LogicProxy {
}
class MastermindClient{
}
class MastermindServer {
}
class PlayControllerProxy{
}
class ResumeControllerProxy {
}
class SaveControllerProxy {
}
class SessionProxy {
}
class StartControllerProxy {
}

package mastermind.dispatchers {
class AttemptDispatcher {
}
class BlackDispatcher {
}
class ColorDispatcher {
}
abstract class Dispatcher {
}
class DispatcherPrototype {
}
class ExistsDispatcher {
}
enum FrameType
class GetTitleDispatcher {
}
class HasNameDispatcher {
}
class LooserDispatcher {
}
class NextDispatcher {
}
class ProposeDispatcher {
}
class RedoableDispatcher {
}
class RedoDispatcher {
}
class ResumeDispatcher {
}
class SaveDispatcher {
}
class SaveNamedDispatcher {
}
class SetTitleDispatcher {
}
class StartDispatcher {
}
class StartNameDispatcher  {
}
class StateDispatcher {
}
class TCPIP {
}
class TitlesDispatcher {
}
class UndoableDispatcher {
}
class UndoDispatcher {
}
class WhiteDispatcher {
}
class WidthDispatcher {
}
class WinnerDispatcher {
}
Dispatcher <|-down- ExistsDispatcher
Dispatcher <|-down- ColorDispatcher
Dispatcher <|-down- BlackDispatcher
Dispatcher <|-down- ResumeDispatcher
Dispatcher <|-down- AttemptDispatcher
Dispatcher <|-down- RedoDispatcher
Dispatcher <|-down- RedoableDispatcher
Dispatcher <|-down- ProposeDispatcher
Dispatcher <|-down- NextDispatcher
Dispatcher <|-down- LooserDispatcher
Dispatcher <|-down- HasNameDispatcher
Dispatcher <|-down- GetTitleDispatcher
Dispatcher <|-down- StartNameDispatcher
Dispatcher <|-down- StartDispatcher
Dispatcher <|-down- SetTitleDispatcher
Dispatcher <|-down- SaveNamedDispatcher
Dispatcher <|-down- SaveDispatcher
Dispatcher <|-down- WinnerDispatcher
Dispatcher <|-down- WidthDispatcher
Dispatcher <|-down- WhiteDispatcher
Dispatcher <|-down- UndoDispatcher
Dispatcher <|-down- UndoableDispatcher
Dispatcher <|-down- TitlesDispatcher
Dispatcher <|-down- StateDispatcher
}
}

LogicImplementation <|-down- LogicImplementationServer
Logic <|-down- LogicProxy
Mastermind <|-down- MastermindClient
PlayController <|-down- PlayControllerProxy
ResumeController <|-down- ResumeControllerProxy
SaveController <|-down- SaveControllerProxy
StartController <|-down- StartControllerProxy


package mastermind.models {

abstract class Combination {
}
class Game {
}
class GameMemento {
}
class ProposedCombination{
}
class Result {
}
class SecretCombination {
}
interface Session {
}
class SessionImplementation
{
}
Session <|-down- SessionImplementation
Combination <|-down- SecretCombination
Combination <|-down- ProposedCombination
package mastermind.models.dao {
interface SessionDao {
}
enum DaoType
class SessionDaoPrototype {
}
SessionDaoPrototype *--> SessionDao
SessionDaoPrototype --> DaoType
package mastermind.models.dao.file {
abstract class CombinationFileDao {
}
interface FileDao {
}
class GameFileDao {
}
class ProposedCombinationFileDao {
}
class SecretCombinationFileDao {
}
class ResultFileDao {
}
class SessionImplementationFileDao {
}
class State {
}
enum StateValue
}
FileDao <|-down- CombinationFileDao
FileDao <|-down- GameFileDao
FileDao <|-down- ResultFileDao
CombinationFileDao <|-down- ProposedCombinationFileDao
CombinationFileDao <|-down- SecretCombinationFileDao
SessionDao <|-down- SessionImplementationFileDao

package mastermind.models.dao.db {
}
}
}

SaveControllerImplementation *--> SessionDao
ResumeControllerImplementation *--> SessionDao

package mastermind.types {
enum Color
enum Error
}

package mastermind.utils. {
class ClosedInterval {
}
abstract class Command {
}
class Console {
}
abstract class Memento {
}
abstract class Menu {
}
interface Originator {
}
class Registry {
}
class TCPIP {
}
abstract class WithConsoleView {
}
class YesNoDialog {
}
WithConsoleView <|-down- YesNoDialog
WithConsoleView <|-down- Menu
}

mastermind.utils.TCPIP <|-down- mastermind.dispatchers.TCPIP

package mastermind.views {
abstract class View {
}
class ColorView {
}
class ErrorView {
}
enum MessageView

package mastermind.views.console {
class AttemptsView {
}
class ColorView {
}
class ConsoleView {
}
class ErrorView {
}
class ProposalView {
}
class ProposedCombinationView {
}
class ResultView {
}
class ResumeView {
}
class SaveView {
}
class SecretCombinationView {
}
class StartView {
}
class SummaryView {
}

package mastermind.views.console.menu {
abstract class Command {
}
enum CommandTitle
class ExitCommand {
}
class GameSelectCommand {
}
class GameSelectMenu {
}
class NewGameCommand {
}
class OpenGameCommand {
}
class PlayMenu {
}
class StartMenu {
}
class ProposeCombinationCommand {
}
class RedoCommand {
}
class UndoCommand {
}

Command <|-down- ExitCommand
ExitCommand --> PlayController
Command <|-down- ProposeCombinationCommand
ProposeCombinationCommand --> PlayController
Command <|-down- RedoCommand
RedoCommand --> PlayController
Command <|-down- UndoCommand
UndoCommand --> PlayController
Command <|-down- GameSelectCommand
GameSelectCommand --> StartController
Command <|-down- NewGameCommand
NewGameCommand --> StartController
Command <|-down- OpenGameCommand
OpenGameCommand --> StartController
GameSelectMenu --> StartController
PlayMenu --> PlayController
PlayMenu ..> ProposeCombinationCommand
PlayMenu ..> UndoCommand
PlayMenu ..> RedoCommand
PlayMenu ..> ExitCommand
StartMenu --> StartController
PlayMenu ..> NewGameCommand
PlayMenu ..> OpenGameCommand
GameSelectMenu ..> GameSelectCommand
}
}
}

Menu <|-down- GameSelectMenu
Menu <|-down- PlayMenu
mastermind.utils.Command <|-down- mastermind.utils.console.menu.Command
WithConsoleView <|-down- AttemptsView
WithConsoleView <|-down- ProposalView
WithConsoleView <|-down- ProposedCombinationView
WithConsoleView <|-down- ResultView
WithConsoleView <|-down- SaveView
WithConsoleView <|-down- SecretCombinationView
WithConsoleView <|-down- StartView
SecretCombinationView --> Controller
ResumeView --> ResumeController
AttemptsView --> PlayController
ProposalView --> PlayController
ProposedCombinationView --> PlayController
ResultView --> PlayController
ResumeView --> ResumeController
StartView --> StartController
SaveView --> SaveController
SummaryView --> PlayController
SummaryView ..> AttemptsView
SummaryView ..> SecretCombinationView
ConsoleView --> StartController
ConsoleView --> PlayController
ConsoleView --> ResumeController
ConsoleView --> SaveController
ConsoleView *--> StartView
ConsoleView *--> ResumeView
ConsoleView *--> SaveView
View <|-down- ConsoleView
mastermind.views.ColorView <|-down- mastermind.views.console.ColorView
mastermind.views.ErrorView <|-down- mastermind.views.console.ErrorView
ControllersVisitor <|-down- View
View ..> AcceptorController

Mastermind *-down-> View
Mastermind *-down-> Logic

LogicImplementation --> SessionImplementation
LogicImplementation --> SessionDao
LogicImplementation --> DaoType
LogicImplementation --> SessionDaoPrototype
SaveControllerImplementation --> SessionDao
StartControllerImplementation --> SessionDao
Controller --> Session
Logic --> Session
LogicImplementationServer --> DaoType
LogicImplementationServer ..> DispatcherPrototype
LogicProxy *--> mastermind.dispatchers.TCPIP
MastermindClient --> LogicProxy
MastermindServer --> DispatcherPrototype
MastermindServer --> LogicImplementationServer
PlayControllerProxy *--> mastermind.dispatchers.TCPIP
ResumeControllerProxy *--> mastermind.dispatchers.TCPIP
SaveControllerProxy *--> mastermind.dispatchers.TCPIP
StartControllerProxy *--> mastermind.dispatchers.TCPIP
Dispatcher --> mastermind.dispatchers.TCPIP
Dispatcher *--> AcceptorController

@enduml

```
