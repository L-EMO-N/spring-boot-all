/** * $Id: UserRepository.java,v 1.0 18/6/28 下午11:10 chenmin Exp $ * <p> * Copyright 2018 Beijing Ultrapower Software Of Shanghai Co.Ltd */package com.profession.commons.repository;import com.profession.commons.beans.User;import org.springframework.data.jpa.repository.JpaRepository;/** * @author chenmin * @Description * @version $Id: UserRepository.java,v 1.1 18/6/28 下午11:10 chenmin Exp $ * @Date Created on 18/6/28 下午11:10 */public interface UserRepository extends JpaRepository<User, Integer> {    User findUserByUserName(String userName);}