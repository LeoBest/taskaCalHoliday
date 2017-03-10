package com.aviva.recruitingtasks.kmol.task1;

import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.model.Holiday;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalculator {

	private final List<Employee> employees;
	private final List<Holiday> holidays;

	public HolidayCalculator(List<Employee> employees, List<Holiday> holidays) {
		this.employees = employees;
		this.holidays = holidays;
	}

	public List<Employee> getWorkingEmployees(LocalDate dateFrom, LocalDate dateTo) {
		List<Employee> empsIsNotInHol = new ArrayList<Employee>();
		for (Employee employee : this.employees) {
			boolean isWorking = true;
			for (Holiday holiday : this.holidays) {
				if (holiday != null) {
					if (holiday.getEmployee().equals(employee) && holiday.isIntersecting(dateFrom, dateTo)) {
						isWorking = false;
						break;
					}
				}
			}
			if (isWorking) {
				empsIsNotInHol.add(employee);
			}

		}
		return empsIsNotInHol;
	}

	public Month getHolidayMonth() {
	    Month bestMonth = null;
	    int maxHolidays = -1;

	    for (Month month : Month.values()) {
	        int holidays = 0;

	        for (Employee employee : this.employees) {
	            for (Holiday holiday : this.holidays) {
	                if ((holiday != null) && holiday.getEmployee().equals(employee)) {
	                    LocalDate dateFrom = LocalDate.of(holiday.getDateFrom().getYear(), month, 1);
                        LocalDate dateTo = dateFrom.with(TemporalAdjusters.lastDayOfMonth());
                        if (holiday.isIntersecting(dateFrom, dateTo)) {
                            holidays++;
                            break;
                        }

                        if (holiday.getDateFrom().getYear() != holiday.getDateTo().getYear()) {
                            dateFrom = LocalDate.of(holiday.getDateTo().getYear(), month, 1);
                            dateTo = dateFrom.with(TemporalAdjusters.lastDayOfMonth());
                            if (holiday.isIntersecting(dateFrom, dateTo)) {
                                holidays++;
                                break;
                            }
                        }
	                }
	            }
	        }

	        if (holidays > maxHolidays) {
                bestMonth = month;
	            maxHolidays = holidays;
	        }
	    }

	    return bestMonth;
	}
}
