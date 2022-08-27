package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuixingonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuixingonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuixingonggaoView;


/**
 * 最新公告
 *
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
public interface ZuixingonggaoService extends IService<ZuixingonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuixingonggaoVO> selectListVO(Wrapper<ZuixingonggaoEntity> wrapper);
   	
   	ZuixingonggaoVO selectVO(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
   	
   	List<ZuixingonggaoView> selectListView(Wrapper<ZuixingonggaoEntity> wrapper);
   	
   	ZuixingonggaoView selectView(@Param("ew") Wrapper<ZuixingonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuixingonggaoEntity> wrapper);
}

