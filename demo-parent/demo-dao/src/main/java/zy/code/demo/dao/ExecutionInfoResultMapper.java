package zy.code.demo.dao;

import zy.code.demo.api.po.ExecutionInfoResult;

public interface ExecutionInfoResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExecutionInfoResult record);

    int insertSelective(ExecutionInfoResult record);

    ExecutionInfoResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExecutionInfoResult record);

    int updateByPrimaryKey(ExecutionInfoResult record);
}