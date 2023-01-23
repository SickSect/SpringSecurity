package com.boot.ugina.bootexmpl.repo;

import com.boot.ugina.bootexmpl.entity.OnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository <OnOrder,Long> {
}
