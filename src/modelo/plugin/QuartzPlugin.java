package modelo.plugin;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletException;

import modelo.TareaPeriodica;
import modelo.TareaPeriodicaJob;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzPlugin implements PlugIn {

	@Override
	public void destroy() {
	}

	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException {
		TareaPeriodica tarea=new TareaPeriodica();
		JobDetail job = new JobDetail();
		job.setName("enviarEmails");
		job.setJobClass(TareaPeriodicaJob.class);
		
		Map dataMap = job.getJobDataMap();
  	   	dataMap.put("TareaPeriodica", tarea);
  	   	try
  	   	{
  	   		//configure the scheduler time, run it every 5 seconds
	    	CronTrigger trigger = new CronTrigger();
	    	trigger.setName("runMeJobTesting");
	    	trigger.setCronExpression(" 0 59 23 ? * SUN");

	    	//schedule it
	    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();   	
	    	scheduler.scheduleJob(job, trigger);
	    }
  	   	catch(ParseException e){e.printStackTrace();}
	    catch(SchedulerException e){e.printStackTrace();}
	    
	}
}
