package csci201.edu.usc.ClubSC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import csci201.edu.usc.ClubSC.domain.Club;
import csci201.edu.usc.ClubSC.domain.ClubSearchRepository;
import csci201.edu.usc.ClubSC.domain.Follow;
import csci201.edu.usc.ClubSC.domain.FollowRepository;

@Service
public class StudentFollowService
{
    @Autowired
    FollowRepository fr;
     
    public void followClub(Long id)
    {
        //add student, club pair to follow database
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long name = ((UserDetailsImpl) auth.getPrincipal()).getId();
        Follow f = new Follow(name,id);
        fr.save(f);
    }

	
}