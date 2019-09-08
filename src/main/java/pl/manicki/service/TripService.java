package pl.manicki.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TripService {
    public String isDateCorrect(String fromDate, String toDate) {
        try {
            LocalDate fromDateParsed = LocalDate.parse(fromDate);
            LocalDate toDateParsed = LocalDate.parse(toDate);
            if (!fromDateParsed.isBefore(toDateParsed)) {
                return "datesError";
            } else if (fromDateParsed.isBefore(LocalDate.now())) {
                return "fromDatePast";
            }
        } catch (Exception e) {
            return "parsingError";
        }
        return "datesAreCorrect";
    }
}
