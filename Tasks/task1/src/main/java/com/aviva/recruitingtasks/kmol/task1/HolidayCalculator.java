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
		List<Employee> workingEmployees = new ArrayList<Employee>();
		Employee empNotInHolidays = null;
		if (this.employees != null) {
			for (Employee employee : this.employees) {
				empNotInHolidays = isInHolidays(employee, dateFrom, dateTo);
				if (empNotInHolidays != null) {
					workingEmployees.add(empNotInHolidays);
				}
			}
		}
		return workingEmployees;
	}

	public Month getHolidayMonth() {
		Month bestMonth = null;
		int maxHolidays = -1;
		for (Month month : Month.values()) {
			int countMonthHolidays = 0;
			countMonthHolidays = this.monthlyMaxHolidays(month);
			if (countMonthHolidays > maxHolidays) {
				bestMonth = month;
				maxHolidays = countMonthHolidays;
			}
		}
		return bestMonth;
	}

	private List<Holiday> getEmplHolidays(Employee employee, List<Holiday> allHolidays) {
		List<Holiday> holidays = new ArrayList<Holiday>();
		if (allHolidays != null && employee != null) {
			for (Holiday holiday : allHolidays) {
				if (holiday.getEmployee().equals(employee)) {
					holidays.add(holiday);
				}
			}
		}
		return holidays;
	}

	private Employee isInHolidays(Employee NameEmployee, LocalDate dateFrom, LocalDate dateTo) {
		Employee emplIsNotInHol = null;
		List<Holiday> emplHolidays = new ArrayList<Holiday>();
		emplHolidays = this.getEmplHolidays(NameEmployee, this.holidays);
		boolean isWorking = true;
		for (Holiday holiday : emplHolidays) {
			isWorking = !holiday.isIntersecting(dateFrom, dateTo);
		}
		if (isWorking) {
			emplIsNotInHol = NameEmployee;
		}
		return emplIsNotInHol;
	}

	private int monthlyMaxHolidays(Month month) {
		int maxHolidays = 0;
		if (this.employees != null && this.holidays != null)
			for (Employee employee : this.employees) {
				List<Holiday> emplHolidays = this.getEmplHolidays(employee, this.holidays);
				for (Holiday holiday : emplHolidays) {
					LocalDate dateFrom = LocalDate.of(holiday.getDateFrom().getYear(), month, 1);
					LocalDate dateTo = dateFrom.with(TemporalAdjusters.lastDayOfMonth());
					maxHolidays = this.incrementIfIntersecHol(holiday, dateFrom, dateTo, maxHolidays);
					if (holiday.getDateFrom().getYear() != holiday.getDateTo().getYear()) {
						dateFrom = LocalDate.of(holiday.getDateTo().getYear(), month, 1);
						dateTo = dateFrom.with(TemporalAdjusters.lastDayOfMonth());
						maxHolidays = this.incrementIfIntersecHol(holiday, dateFrom, dateTo, maxHolidays);
					}
				}
			}
		return maxHolidays;
	}

	private int incrementIfIntersecHol(Holiday holiday, LocalDate dateFrom, LocalDate dateTo, int countHolidays) {
		if (holiday.isIntersecting(dateFrom, dateTo)) {
			countHolidays++;
		}
		return countHolidays;
	}
}
