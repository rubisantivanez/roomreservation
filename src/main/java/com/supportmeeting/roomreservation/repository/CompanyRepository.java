package com.supportmeeting.roomreservation.repository;

import com.supportmeeting.roomreservation.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
