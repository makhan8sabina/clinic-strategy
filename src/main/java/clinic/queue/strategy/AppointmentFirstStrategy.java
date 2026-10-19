package clinic.queue.strategy;
import clinic.queue.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class AppointmentFirstStrategy implements QueueStrategy {
    @Override
    public Optional<clinic.queue.Patient> selectNext(List<clinic.queue.Patient> waitingPatients) {
        return waitingPatients.stream().min(Comparator.comparing(Patient::hasAppointment).reversed().thenComparingInt(clinic.queue.Patient::arrivalMinute));
    }
    @Override
    public String name() {
        return "Appointment First";
    }
}