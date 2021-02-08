package com.example.reposetories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.beans.LogData;

public interface LogReposetory extends JpaRepository<LogData, Integer> {

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value="call contactmanager.GetAll(?)")
	List<LogData> getContactLogs(int contactId);
}
