package digicom.facebook.obj;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import br.com.digicom.lib.dao.DaoException;

import dafitiafil.modelo.FacebookPerfil;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.FacebookPerfilRegraColecao;

public class FbProgramador {
	
	

	public void executa() {

		
		
		
		SchedulerFactory sf = new StdSchedulerFactory();
        try {
        	//FacebookPerfil perfil = getPerfil();	
    		//FbEnviadorObj obj = new FbEnviadorObj(perfil);
    		
            Scheduler sched = sf.getScheduler();
            JobDetail job2 = newJob(FbEnviadorObj.class)
                .withIdentity("job2", "group2")
                .build();

            
            CronTrigger trigger2 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .withSchedule(cronSchedule("0 0/120 10-23 * * ?"))
                    .forJob(job2)
                    .build();
          
            
           sched.scheduleJob(job2, trigger2);

           sched.start();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        } 
	}
}
