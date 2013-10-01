package modelo;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TareaPeriodicaJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		Map dataMap = context.getJobDetail().getJobDataMap();
		TareaPeriodica tarea=(TareaPeriodica)dataMap.get("TareaPeriodica");
		tarea.hacer();
		
	}

}
