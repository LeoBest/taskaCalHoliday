package unitTest;

import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.ANNA;
import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.JOHN;
import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.ROB;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.aviva.recruitingtasks.kmol.task1.HolidayCalculator;
import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.model.Holiday;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaHolidays;

public class testTest {

	@Test
	public void test() {
		HolidayCalculator test = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES,
				SampleAvivaHolidays.AVIVA_HOLIDAYS);
		List<Employee> workEmp1 = test.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 2),
				LocalDate.of(2017, Month.FEBRUARY, 8));
		List<Employee> result1 = SampleAvivaEmployees.AVIVA_EMPLOYEES;
		assertEquals(workEmp1, result1);

		List<Employee> workEmp2 = test.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 1),
				LocalDate.of(2017, Month.FEBRUARY, 8));
		List<Employee> result2 = new ArrayList<Employee>();
		result2.add(SampleAvivaEmployees.ANNA);
		result2.add(SampleAvivaEmployees.ROB);
		assertEquals(workEmp2, result2);

		List<Employee> workEmp3 = test.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 5),
				LocalDate.of(2017, Month.FEBRUARY, 15));
		List<Employee> result3 = new ArrayList<Employee>();
		result3.add(SampleAvivaEmployees.JOHN);
		result3.add(SampleAvivaEmployees.ROB);
		assertEquals(workEmp3, result3);

		List<Employee> workEmp4 = test.getWorkingEmployees(LocalDate.of(2017, Month.FEBRUARY, 12),
				LocalDate.of(2017, Month.FEBRUARY, 14));
		List<Employee> result4 = new ArrayList<Employee>();
		result4.add(SampleAvivaEmployees.JOHN);
		result4.add(SampleAvivaEmployees.ROB);
		assertEquals(workEmp4, result4);
		
		
		HolidayCalculator test2 = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES,
				Arrays.asList(new Holiday[] {
						new Holiday(JOHN, LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 1)),
						new Holiday(ANNA, LocalDate.of(2017, Month.MARCH, 10), LocalDate.of(2017, Month.MARCH, 10)),
						new Holiday(ROB, LocalDate.of(2017, Month.MARCH, 10), LocalDate.of(2017, Month.MARCH, 11)) }));

		Month holMonth5 = test2.getHolidayMonth();
		Month result5 = Month.MARCH;
		assertEquals(holMonth5, result5);

		HolidayCalculator test3 = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES,
				Arrays.asList(new Holiday[] {
						new Holiday(JOHN, LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 1)),
						new Holiday(ANNA, LocalDate.of(2017, Month.MARCH, 10),
								LocalDate.of(2017, Month.MARCH, 10)), }));

		Month holMonth6 = test3.getHolidayMonth();
		Month result6 = Month.FEBRUARY;
		assertEquals(holMonth6, result6);

	}

}
