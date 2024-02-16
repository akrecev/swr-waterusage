package ru.rosniivh.swr.service;

import java.util.List;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;

public interface UserService {
    List<RfSubjectEntity> getUserRfs();
}
