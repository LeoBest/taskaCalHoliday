package com.aviva.recruitingtasks.kmol.task1;

import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.model.Holiday;

import java.time.LocalDate;
import java.time.Month;
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
			for (Holiday holiday : holidays) {
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

	public Month getHolidayMonth(int year) {
		throw new UnsupportedOperationException();
	}

}
