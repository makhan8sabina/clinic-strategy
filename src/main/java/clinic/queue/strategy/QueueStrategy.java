package clinic.queue.strategy;
import clinic.queue.Patient;
import java.util.List;
import java.util.Optional;

public interface QueueStrategy {
    Optional<Patient> selectNext(List<Patient> waitingPatients);
    String name();
}