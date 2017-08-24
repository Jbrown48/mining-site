package com.jjmining.miningsite.miningsite.models.data;

import com.jjmining.miningsite.miningsite.models.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by jarrett on 8/21/2017.
 */
@Repository
@Transactional
public interface PartDao extends CrudRepository<Part, Integer> {
}
