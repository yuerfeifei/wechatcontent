package com.yq.wechatcontent.model.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T, PK> {

	List<T> query(@Param("domain") T domain);

	T load(@Param("id") PK id);

	void insert(@Param("domain") T domain);

	void update(@Param("domain") T domain);

	void delete(@Param("id") PK id);

}
