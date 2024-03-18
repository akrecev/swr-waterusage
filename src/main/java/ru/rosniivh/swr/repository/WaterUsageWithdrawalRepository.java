package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rosniivh.swr.domain.object.WaterUsageWithdrawalEntity;

import java.util.List;

public interface WaterUsageWithdrawalRepository extends JpaRepository<WaterUsageWithdrawalEntity, Integer> {

    @Query("SELECT DISTINCT wuw.year FROM WaterUsageWithdrawalEntity wuw")
    List<Short> findYear2TP();
}
