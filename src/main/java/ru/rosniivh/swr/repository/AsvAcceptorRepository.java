package ru.rosniivh.swr.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;
import java.util.List;

@Repository
public interface AsvAcceptorRepository  extends JpaRepository<AsvAcceptorEntity, Integer>,
        JpaSpecificationExecutor<AsvAcceptorEntity> {


    default List<AsvAcceptorEntity> findAll(AsvAcceptorFilter filter, Integer limit) {
        Pageable l1 = PageRequest.of(0,limit,Sort.DEFAULT_DIRECTION,"fio");
       // Pageable l1 = PageRequest.ofSize(limit);
        return filter == null ? findAll().stream().toList() : findAll(filter.toSpecification(),l1).stream().toList();
    }
}
