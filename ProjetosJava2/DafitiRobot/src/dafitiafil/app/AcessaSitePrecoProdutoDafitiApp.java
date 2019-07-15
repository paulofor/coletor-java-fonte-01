package dafitiafil.app;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import dafitiafil.obj.AcessaSitePrecoProdutoDafitiObj;
import digicom.facebook.obj.FbProgramador;

public class AcessaSitePrecoProdutoDafitiApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FbProgramador fbProg = new FbProgramador();
		fbProg.executa();
		

		AcessaSitePrecoProdutoDafitiObj obj = new AcessaSitePrecoProdutoDafitiObj();
		
		
		SchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler sched = sf.getScheduler();
            JobDetail job1 = newJob(AcessaSitePrecoProdutoDafitiObj.class)
                .withIdentity("job1", "group1")
                .build();
            System.out.println("Criando Job");
            CronTrigger trigger1 = newTrigger()
                .withIdentity("trigger1", "group1")
                //.withSchedule(dailyAtHourAndMinute(14,51))
                .withSchedule(dailyAtHourAndMinute(6,30))
                .forJob(job1)
                .build();
            
           sched.scheduleJob(job1, trigger1);

           sched.start();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}

}
