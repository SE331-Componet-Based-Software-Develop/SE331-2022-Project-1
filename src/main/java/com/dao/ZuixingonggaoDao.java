package com.dao;

import com.entity.ZuixingonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuixingonggaoVO;
import com.entity.view.ZuixingonggaoView;


/**
 * 最新公告
 * 
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
public interface ZuixingonggaoDao extends BaseMapper<ZuixingonggaoEntity> {
	
	List<ZuixingonggaoVO> selectListVO(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
	
	ZuixingonggaoVO selectVO(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
	
	List<ZuixingonggaoView> selectListView(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);

	List<ZuixingonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
	
	ZuixingonggaoView selectView(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
}
