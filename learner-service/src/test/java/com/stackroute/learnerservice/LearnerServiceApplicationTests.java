package com.stackroute.learnerservice;

import com.stackroute.learnerservice.exception.LearnerAlreadyExistException;
import com.stackroute.learnerservice.model.Learner;
import com.stackroute.learnerservice.repository.LearnerRepository;
import com.stackroute.learnerservice.service.LearnerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LearnerServiceApplicationTests {

	@Mock
	private LearnerRepository learnerRepository;

	@InjectMocks
	private LearnerServiceImpl learnerService;

	@Test
	void contextLoads() throws LearnerAlreadyExistException {
		Learner learner = new Learner("rankadhanush99@gmail.com", "dhanush","Kumar","password",
				"7823028608","male",22,"","leaner");
		when(learnerRepository.save(learner)).thenReturn(learner);
		learnerService.saveLearner(learner);
		verify(learnerRepository,times(1)).save(learner);

	}

}
