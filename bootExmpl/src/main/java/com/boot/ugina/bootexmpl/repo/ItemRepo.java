package com.boot.ugina.bootexmpl.repo;

import com.boot.ugina.bootexmpl.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo  extends JpaRepository<Item, Long> {

}
