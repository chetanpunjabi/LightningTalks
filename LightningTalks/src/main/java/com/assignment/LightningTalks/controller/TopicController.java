package com.assignment.LightningTalks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.LightningTalks.model.Topic;
import com.assignment.LightningTalks.service.TopicService;


@Controller
public class TopicController {

	@Autowired
	TopicService topicService;
	
	/**
	 * Mapping for home page of the application
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	/**
	 * Mapping for displaying all topic proposals submitted
	 * @return
	 */
	/*@GetMapping("/get")
	public ModelAndView getAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Topic> submittedTopics = topicService.getAll();
		modelAndView.addObject("ListOfTopicsa", "Chetan");
		modelAndView.setViewName("ViewTopics");
		return modelAndView;
	}*/
	
//	@RequestMapping(value = "/get", method=RequestMethod.GET)
//	public ModelAndView getAll(){
//		ModelAndView modelAndView = new ModelAndView("ViewTopics");
//		//List<Topic> submittedTopics = topicService.getAll();
//		modelAndView.addObject("ListOfTopics", "Chetan");
//		//modelAndView.setViewName("ViewTopics");
//		return modelAndView;
//	}
	
	@GetMapping("/get")
	public String getAll(Model model){
		model.addAttribute("ListOfTopics", new String("Chetan"));
		  return "ViewTopics";
	}
	
	
	/**
	 * Mapping for saving topic details
	 * @return
	 */
	@RequestMapping(value = "/pages/saveTopic", method = RequestMethod.POST)
	public ModelAndView addTopic(@Valid Topic topic, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView mv = new ModelAndView();
		//Check for validations
		if(bindingResult.hasErrors()) {
			mv.setViewName("redirect:TopicProposal.html");
			mv.addObject("errors", bindingResult);
		}
		else {
			String result = topicService.addTopic(topic);
			//mv.setViewName("redirect:" + result + ".html");
			mv.setViewName("TopicProposal");
			
		}
			return mv;
		}
			
	}

