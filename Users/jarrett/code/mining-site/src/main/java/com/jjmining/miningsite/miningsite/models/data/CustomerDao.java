package com.jjmining.miningsite.miningsite.models.data;

import com.jjmining.miningsite.miningsite.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by jarrett on 8/3/2017.
 */

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
