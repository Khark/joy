package com.joy.demo.repository.maria.member;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.demo.entity.maria.memberEntity;


public interface MemberRepository extends JpaRepository<memberEntity , Long>  {

}
