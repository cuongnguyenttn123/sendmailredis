package com.github.sonus21.task.executor.repository;

import com.github.sonus21.task.executor.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {
}
