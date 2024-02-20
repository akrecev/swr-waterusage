package ru.rosniivh.swr.repository.asv;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;

@Repository
public interface AsvImportLegalSubjectRepository
        extends JpaRepository<AsvImportLegalSubjectEntity, Integer>,
                JpaSpecificationExecutor<AsvImportLegalSubjectEntity> {

    default List<AsvImportLegalSubjectEntity> findAll(AsvImportLegalSubjectFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }

    @Query(
            value = "SELECT ls FROM AsvImportLegalSubjectEntity ls "
                    + "WHERE ls.fullName LIKE %?1% AND ls.ogrn LIKE %?2% "
                    + "AND ls.okpo LIKE %?3% AND ls.placeAddress LIKE %?4% "
                    + "AND ls.legalAddress LIKE %?5% AND ls.okato LIKE %?6%")
    List<AsvImportLegalSubjectEntity> getByTypeOne(
            String name, String ogrn, String okpo, String postAddress, String legalAddress, String okato);


    @Query(
            value = "SELECT ls FROM AsvImportLegalSubjectEntity ls "
                    + "WHERE ls.inn LIKE %?1% AND ls.fullName LIKE %?2%")
    List<AsvImportLegalSubjectEntity> getByTypeTwo(String inn, String name);

    @Query(value = "SELECT ls FROM AsvImportLegalSubjectEntity ls WHERE ls.fullName LIKE :fullName")
    List<AsvImportLegalSubjectEntity> getByFullName(String fullName);

    @Query(value = "SELECT ls FROM AsvImportLegalSubjectEntity ls WHERE ls.inn LIKE %?1%")
    List<AsvImportLegalSubjectEntity> getByInn(String inn);

    //    default Page<AsvImportLegalSubjectEntity> findAllPage(AsvImportLegalSubjectFilter filter, Pageable pageable) {
//        return filter == null ? findAll(pageable) : findAll(filter.toSpecification(), pageable);
//    }
}
