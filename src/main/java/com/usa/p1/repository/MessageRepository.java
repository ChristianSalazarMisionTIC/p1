package com.usa.p1.repository;

import com.usa.p1.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Integer> {
}
