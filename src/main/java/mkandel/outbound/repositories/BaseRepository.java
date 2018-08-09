/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.outbound.repositories;

import mkandel.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String>, QueryDslPredicateExecutor<T> {
}
