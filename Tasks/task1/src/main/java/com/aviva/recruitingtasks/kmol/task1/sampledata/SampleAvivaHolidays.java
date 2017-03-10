package com.aviva.recruitingtasks.kmol.task1.sampledata;

import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.JOHN;
import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.ANNA;
import static com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees.ROB;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aviva.recruitingtasks.kmol.task1.model.Holiday;

public class SampleAvivaHolidays {

	private static final List<Holiday> JOHN_HOLIDAYS = Arrays.asList(new Holiday[]
		{
			new Holiday(JOHN, LocalDate.of(2017, Month.FEBRUARY, 1), LocalDate.of(2017, Month.FEBRUARY, 1))
		}
	);

	private static final List<Holiday> ANNA_HOLIDAYS = Arrays.asList(new Holiday[]
		{
			new Holiday(ANNA, LocalDate.of(2017, Month.FEBRUARY, 10), LocalDate.of(2017, Month.FEBRUARY, 20))
		}
	);

	private static final List<Holiday> ROB_HOLIDAYS = new ArrayList<Holiday>() {
	};

	public static final List<Holiday> AVIVA_HOLIDAYS = new ArrayList<Holiday>();
	static {
		AVIVA_HOLIDAYS.addAll(JOHN_HOLIDAYS);
		AVIVA_HOLIDAYS.addAll(ANNA_HOLIDAYS);
		AVIVA_HOLIDAYS.addAll(ROB_HOLIDAYS);
	}

}
