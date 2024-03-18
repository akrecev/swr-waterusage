package ru.rosniivh.swr.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosniivh.swr.repository.WaterUsageWithdrawalRepository;
import ru.rosniivh.swr.service.WaterUsageService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class WaterUsageServiceImpl implements WaterUsageService {
    private final WaterUsageWithdrawalRepository waterUsageWithdrawalRepository;


    @Override
    public List<Short> getYear2TP() {
        return waterUsageWithdrawalRepository.findYear2TP();
    }
}
