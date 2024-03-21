package ru.rosniivh.swr.service;

import ru.rosniivh.swr.dto.filter.BasinFilterForUser;
import ru.rosniivh.swr.dto.report.BasinFilterForUserReport;

import java.util.List;

public interface RfSubjectService {

    BasinFilterForUserReport getBasinFilterForUser();
}
