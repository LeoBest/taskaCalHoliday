package com.aviva.recruitingtasks.kmol.task1.model;

import java.time.LocalDate;

public class Holiday {

	private Employee employee;
	private LocalDate dateFrom;
	private LocalDate dateTo;

	public Holiday(Employee employee, LocalDate dateFrom, LocalDate dateTo) {
		this.employee = employee;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public boolean isIntersecting(LocalDate dateFrom, LocalDate dateTo) {
		return dateFrom.isBefore(this.dateTo) && this.dateFrom.isBefore(dateTo) || dateFrom.isEqual(this.dateTo)
				|| this.dateFrom.isEqual(dateTo);

	}

	@Override
	public String toString() {
		return "Holiday [employee=" + employee + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateFrom == null) ? 0 : dateFrom.hashCode());
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holiday other = (Holiday) obj;
		if (dateFrom == null) {
			if (other.dateFrom != null)
				return false;
		} else if (!dateFrom.equals(other.dateFrom))
			return false;
		if (dateTo == null) {
			if (other.dateTo != null)
				return false;
		} else if (!dateTo.equals(other.dateTo))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}
}
