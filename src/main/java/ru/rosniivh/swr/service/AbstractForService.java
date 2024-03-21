package ru.rosniivh.swr.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractForService {

    private final AsvImportAuthOrgContractRepository repository;

    protected <T> Predicate buildIn(CriteriaBuilder builder, Path path, Collection<T> values) {
        CriteriaBuilder.In<T> inCriteria = builder.in(path);
        values.forEach(inCriteria::value);
        return inCriteria;
    }

    protected List<Integer> getAuthOrgHierarchyIds(Integer id) {
        List<Integer> list = new ArrayList<>();
        List<Integer> todo = new ArrayList<>();
        list.add(id);
        todo.add(id);
        while(todo.size()>0){
            Integer i = todo.remove(0);
            List<Integer> curlist = repository.findByParentId(i).stream()
                    .map(AsvImportAuthOrgContractEntity::getId).toList();
            list.addAll(curlist);
            todo.addAll(curlist);
        }
        return list;
    }
}
