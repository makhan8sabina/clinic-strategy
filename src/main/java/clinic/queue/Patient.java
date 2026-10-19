package clinic.queue;

public record Patient(String name,
                      int arrivalMinute,
                      int severityLevel,
                      int expectedMinutes,
                      boolean hasAppointment){
    private static final int MIN_SEVERITY = 1;
    private static final int MAX_SEVERITY = 5;

    public Patient {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("clinic.queue.Patient name must not be blank");
        }
        if (arrivalMinute < 0) {
            throw new IllegalArgumentException("Arrival minute must not be negative");
        }
        if (severityLevel < MIN_SEVERITY || severityLevel > MAX_SEVERITY) {
            throw new IllegalArgumentException("Severity level must be between 1 and 5");
        }
        if (expectedMinutes <= 0) {
            throw new IllegalArgumentException("Expected visit duration must be positive");
        }
    }

    @Override
    public String toString() {
        return String.format("%-7s (arrived=%d, severity=%d, visit=%d min, booked=%s)",
                name, arrivalMinute, severityLevel, expectedMinutes, hasAppointment);
    }
}