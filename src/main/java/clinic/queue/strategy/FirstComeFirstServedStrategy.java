package clinic.queue.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FirstComeFirstServedStrategy implements QueueStrategy{
    @Override
    public Optional<clinic.queue.Patient> selectNext(List<clinic.queue.Patient>waitingPatiens){
        return waitingPatiens.stream().min(Comparator.comparingInt(clinic.queue.Patient::arrivalMinute));
    }
    @Override
    public String name(){
        return "First Come first served";
    }
}