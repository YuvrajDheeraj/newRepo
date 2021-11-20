package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.JobTitle;
import ls.services.CountryService;
import ls.services.JobTitleService;
import ls.services.StateService;

@Controller 
public class JobTitleController {

	@Autowired private JobTitleService jobtitleservice;
	
	

	@RequestMapping("jobTitle")
	public String getJobTitle(Model model){
		model.addAttribute("jobtitle", jobtitleservice.getJobTitle());
		return "jobTitle";
	}
	
	@RequestMapping("jobTitle/addNew")
	public String save(JobTitle jobtitle) {
		jobtitleservice.save(jobtitle);
		return "redirect:/jobTitle";
	}

	@PostMapping("jobTitle/update")
	public String update(JobTitle jobtitle) {
		jobtitleservice.save(jobtitle);
		return "redirect:/jobTitle";
	}
	
	@RequestMapping("jobTitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id){
		return jobtitleservice.findById(id);
	}
	
	@RequestMapping(value="jobTitle/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		jobtitleservice.delete(id);
		return "redirect:/jobTitle";
	}
}
