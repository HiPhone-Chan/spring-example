package com.chf.spring.server.service.batch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.chf.spring.common.constants.MyProfiles;

@Service
@Profile(MyProfiles.BATCH)
public class BatchService {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job taskJob;

	@Scheduled(cron = "0 0 1 * * ?")
	public void task() {
		try {
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder().addDate("date", new Date());
			jobLauncher.run(taskJob, jobParametersBuilder.toJobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}

	}
}
