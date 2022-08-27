package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YimiaomingchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YimiaomingchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YimiaomingchengView;


/**
 * 疫苗名称
 *
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
public interface YimiaomingchengService extends IService<YimiaomingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YimiaomingchengVO> selectListVO(Wrapper<YimiaomingchengEntity> wrapper);
   	
   	YimiaomingchengVO selectVO(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
   	
   	List<YimiaomingchengView> selectListView(Wrapper<YimiaomingchengEntity> wrapper);
   	
   	YimiaomingchengView selectView(@Param("ew") Wrapper<YimiaomingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YimiaomingchengEntity> wrapper);
}

