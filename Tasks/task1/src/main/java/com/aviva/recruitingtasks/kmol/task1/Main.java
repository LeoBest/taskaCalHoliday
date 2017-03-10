package com.aviva.recruitingtasks.kmol.task1;

import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.*;

import com.aviva.recruitingtasks.kmol.task1.model.Holiday;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaHolidays;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		HolidayCalculator calculator = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES, SampleAvivaHolidays.AVIVA_HOLIDAYS);
		System.out.println(calculator.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 2), LocalDate.of(2017, Month.FEBRUARY, 8)));
		System.out.println(calculator.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 8)));
		System.out.println(calculator.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 5), LocalDate.of(2017, Month.FEBRUARY, 15)));
		System.out.println(calculator.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 12), LocalDate.of(2017, Month.FEBRUARY, 14)));

		calculator = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES, Arrays.asList( new Holiday[] {
		        new Holiday(JOHN, LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 1)),
                new Holiday(ANNA, LocalDate.of(2017, Month.MARCH, 10), LocalDate.of(2017, Month.MARCH, 10)),
                new Holiday(ROB, LocalDate.of(2017, Month.MARCH, 10), LocalDate.of(2017, Month.MARCH, 11))
		}));
		System.out.println(calculator.getHolidayMonth());

		calculator = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES, Arrays.asList( new Holiday[] {
                new Holiday(JOHN, LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 1)),
                new Holiday(ANNA, LocalDate.of(2017, Month.MARCH, 10), LocalDate.of(2017, Month.MARCH, 10)),
        }));
        System.out.println(calculator.getHolidayMonth());
	}
}
