package clinic.queue;

import clinic.queue.strategy.AppointmentFirstStrategy;
import clinic.queue.strategy.FirstComeFirstServedStrategy;
import clinic.queue.strategy.SeverityFirstStrategy;
import clinic.queue.strategy.ShortestVisitFirstStrategy;

public class Main{
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom(new FirstComeFirstServedStrategy());

        waitingRoom.checkIn(new Patient("Sabina", 0, 2, 15, true));
        waitingRoom.checkIn(new Patient("Yuliya", 5, 5, 40, false));
        waitingRoom.checkIn(new Patient("Amir", 8, 1, 5, false));
        waitingRoom.checkIn(new Patient("Zhursin", 12, 3, 20, true));
        waitingRoom.checkIn(new Patient("Bekarys", 15, 4, 25, false));
        waitingRoom.checkIn(new Patient("Miras", 18, 2, 10, false));

        callAndPrint(waitingRoom);
        waitingRoom.setStrategy(new SeverityFirstStrategy());
        callAndPrint(waitingRoom);
        waitingRoom.setStrategy(new ShortestVisitFirstStrategy());
        callAndPrint(waitingRoom);
        waitingRoom.setStrategy(new AppointmentFirstStrategy());
        callAndPrint(waitingRoom);
        callAndPrint(waitingRoom);
        callAndPrint(waitingRoom);
        callAndPrint(waitingRoom);
    }

    private static void callAndPrint(WaitingRoom room) {
        String strategyName = room.currentStrategyName();
        room.callNextPatient().ifPresentOrElse(
                patient -> System.out.printf("[%-24s] called: %s | left in queue: %d%n",
                        strategyName, patient, room.waitingCount()),
                () -> System.out.printf("[%-24s] waiting room is empty%n", strategyName));
    }
}