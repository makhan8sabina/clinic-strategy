package clinic.queue.strategy;
import clinic.queue.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SeverityFirstStrategy implements QueueStrategy{
    @Override
    public Optional<clinic.queue.Patient> selectNext(List<clinic.queue.Patient> waitingPatients) {
        return waitingPatients.stream().min(Comparator.comparingInt(clinic.queue.Patient::severityLevel).reversed().thenComparingInt(Patient::arrivalMinute));
    }
    @Override
    public String name() {
        return "Severity First (triage)";
    }
}

