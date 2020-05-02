package com.wugui.datax.admin.mapper;

import com.wugui.datax.admin.entity.JobTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * job info
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
@Mapper
public interface JobTemplateMapper {
	
	List<JobTemplate> pageList(@Param("offset") int offset,
							   @Param("pagesize") int pagesize,
							   @Param("jobGroup") int jobGroup,
							   @Param("jobDesc") String jobDesc,
							   @Param("executorHandler") String executorHandler,
							   @Param("author") String author);
	
	int pageListCount(@Param("offset") int offset,
					  @Param("pagesize") int pagesize,
					  @Param("jobGroup") int jobGroup,
					  @Param("jobDesc") String jobDesc,
					  @Param("executorHandler") String executorHandler,
					  @Param("author") String author);
	
	int save(JobTemplate info);
	
	JobTemplate loadById(@Param("id") int id);
	
	int update(JobTemplate xxlJobTemplate);
	
	int delete(@Param("id") long id);
}
