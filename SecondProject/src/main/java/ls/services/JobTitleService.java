package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.JobTitle;
import ls.repositories.JobTitleRepository;

@Service 
public class JobTitleService {
	
@Autowired JobTitleRepository jobtitlerepository;
	
	public List<JobTitle> getJobTitle(){
		return jobtitlerepository.findAll();
	}
	
	public void save(JobTitle jobtitle) {
		jobtitlerepository.save(jobtitle);
	}

	public Optional<JobTitle> findById(int id){
		return jobtitlerepository.findById(id);
		
	}
	
	public void delete(int id) {
		jobtitlerepository .deleteById(id);
	}
	

}
