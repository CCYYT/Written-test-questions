package com.example.untitled7.dao;


import com.example.untitled7.domain.BrokenPriceGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrokenPriceGoodsDao {

    /**
    * @Description: 批量获取破价信息
    * @Param: [platform, batchNo, count :获取数量, status: 链接的状态]
    * @return： List<BrokenPriceGoods> 结果列表
    * @Author: CCYT
    * @Date: 2023/11/26
    */
    List<BrokenPriceGoods> queryByPlatformAndBatchNoAndCount(@Param("platform") String platform, @Param("batchNo") String batchNo, @Param("count") Integer count,@Param("status") Integer status);

    /**
     * @Description: 批量修改链接的状态
     * @Param: [ids, status]
     * @return： java.lang.Integer  影响的行数
     * @Author: CCYT
     * @Date: 2023/11/27
     */
    Integer batchSetStatusByIds(@Param("ids") List<Integer> ids, @Param("status") Integer status);

    /**
     * @Description: 通过sku_id修改链接的状态
     * @Param: [sku_id, status]
     * @return： java.lang.Integer  影响的行数
     * @Author: CCYT
     * @Date: 2023/11/27
     */
    Integer setStatusBySkuId(@Param("sku_id") String sku_id, @Param("status") Integer status);

        /**
        * @Description: 批量修改状态 通过时间差与状态值，现在的时间-time字段的时间 如果大于timeDifference就修改状态
        * @Param: [timeDifference 现在的时间与time字段的差值 单位(秒, preStatus 之前的状态, status 修改的状态]
        * @return： java.lang.Integer
        * @Author: CCYT
        * @Date: 2023/11/27
        */
    Integer batchSetStatusByThroughTimeDifference(@Param("timeDifference") Long timeDifference,@Param("preStatus") Integer preStatus,@Param("status") Integer status);
}
