package com.dao;

import com.entity.YimiaomingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YimiaomingchengVO;
import com.entity.view.YimiaomingchengView;


/**
 * 疫苗名称
 * 
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
public interface YimiaomingchengDao extends BaseMapper<YimiaomingchengEntity> {
	
	List<YimiaomingchengVO> selectListVO(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
	
	YimiaomingchengVO selectVO(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
	
	List<YimiaomingchengView> selectListView(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);

	List<YimiaomingchengView> selectListView(Pagination page,@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
	
	YimiaomingchengView selectView(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
}
