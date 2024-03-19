package ru.rosniivh.swr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rosniivh.swr.domain.object.WaterUsageWithdrawalEntity;

public interface WaterUsageWithdrawalRepository extends JpaRepository<WaterUsageWithdrawalEntity, Integer> {

    @Query("SELECT DISTINCT wuw.year FROM WaterUsageWithdrawalEntity wuw")
    List<Short> findYear2TP();
}
