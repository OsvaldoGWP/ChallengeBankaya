package com.bankaya.challenge.repository;

import com.bankaya.challenge.model.RequestHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestHistoryRepository {

    RequestHistory save(RequestHistory requestHistory);
}
