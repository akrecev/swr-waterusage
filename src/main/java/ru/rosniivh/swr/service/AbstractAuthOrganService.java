package ru.rosniivh.swr.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;

@RequiredArgsConstructor
public abstract class AbstractAuthOrganService {

    private final AsvImportAuthOrgContractRepository repository;

    protected List<Integer> getAuthOrgHierarchyIds(Integer id) {
        List<Integer> list = new ArrayList<>();
        List<Integer> todo = new ArrayList<>();
        list.add(id);
        todo.add(id);
        while (todo.size() > 0) {
            Integer i = todo.remove(0);
            List<Integer> curlist = repository.findByParentId(i).stream()
                    .map(AsvImportAuthOrgContractEntity::getId)
                    .toList();
            list.addAll(curlist);
            todo.addAll(curlist);
        }
        return list;
    }
}
