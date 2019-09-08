/**
 * 
 */
package com.providus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.providus.model.ProvidusOrder;

/**
 * @author SUMIT VERMA
 *
 */
@Repository
public interface ProvidusOrderRepository extends CrudRepository<ProvidusOrder, Integer>{
	
	
	@Query("from ProvidusOrder where dueDate <= DATEADD(day,-7, NOW()) and orderStatus !='COMPLETED' ")
	List<ProvidusOrder> getDueOrders();

}
