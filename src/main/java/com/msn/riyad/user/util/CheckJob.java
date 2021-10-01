/**
 * 
 */
package com.msn.riyad.user.util;

import com.msn.riyad.user.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Riyad
 *
 */
public class CheckJob implements Job {
	
	@Autowired
	private UserService userService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			//Job for Pickup expiry
			userService.job();

		} catch (Exception e) {
		}
	}
}
