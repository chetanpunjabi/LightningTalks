package com.assignment.LightningTalks.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.LightningTalks.dao.TopicRepository;
import com.assignment.LightningTalks.model.Topic;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	/**
	 * Returns the entire list of topics added thus far
	 * @return
	 */
	public List<Topic> getAll(){
		return topicRepository.findAll();
	}
	
	/**
	 * Logic for adding a topic from the UI
	 * @param topic
	 * @return
	 */
	public String addTopic(Topic topic) {
		topic.setLightningTalkDate(getFirstTuesday());
		topicRepository.save(topic);
		return "Success";
	}
	
	/**
	 * Utility method to calculate the first Tuesday of the next even month
	 * @return
	 */
	public LocalDate getFirstTuesday() {
		Calendar calendar = Calendar.getInstance();
		LocalDate firstTuesday;
		Date currentDate = new Date();
		calendar.setTime(currentDate);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		int date = calendar.get(Calendar.DATE);
		if((month + 1) % 2 != 0) {
			month = month + 1;
			if(month > 11) {
				year = year + 1;
				month = month - 11;
			}
		}
		calendar = getCalendarObjectForFirstTuesday(month, year);
	    if(date < calendar.get(Calendar.DATE)) {
	    	firstTuesday = LocalDate.of(year, month + 1, calendar.get(Calendar.DATE));
	    }
	    else {
	    	month = month + 2;
	    	if(month > 11) {
				year = year + 1;
				month = month - 11;
			}
	    	calendar = getCalendarObjectForFirstTuesday(month, year);
		    firstTuesday = LocalDate.of(year, month + 1, calendar.get(Calendar.DATE));
	    }
	    return firstTuesday;
	}
	
	/**
	 * Returns a Calendar object for the first Tuesday of the month based on the provided parameters
	 * @param month
	 * @param year
	 * @return
	 */
	public Calendar getCalendarObjectForFirstTuesday(int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	    calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.YEAR, year);
	    return calendar;
	}
}