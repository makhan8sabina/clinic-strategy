package clinic.queue;

import clinic.queue.strategy.QueueStrategy;

import java.util.*;

public class WaitingRoom{
    private final List<Patient> waitingPatients=new ArrayList<>();
    private QueueStrategy queueStrategy;

    public WaitingRoom(QueueStrategy queueStrategy) {
        this.queueStrategy = Objects.requireNonNull(queueStrategy);
    }

    public void setStrategy(QueueStrategy newStrategy) {
        this.queueStrategy = Objects.requireNonNull(newStrategy);
    }

    public void checkIn(Patient patient) {
        waitingPatients.add(Objects.requireNonNull(patient));
    }

    public Optional<Patient> callNextPatient() {
        Optional<Patient> next = queueStrategy.selectNext(List.copyOf(waitingPatients));
        next.ifPresent(waitingPatients::remove);
        return next;
    }

    public String currentStrategyName() {
        return queueStrategy.name();
    }

    public int waitingCount() {
        return waitingPatients.size();
    }
}