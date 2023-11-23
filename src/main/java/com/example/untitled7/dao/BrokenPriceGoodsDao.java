package com.example.untitled7.dao;

import com.example.untitled7.domain.BrokenPriceGoods;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;


@Component
public class BrokenPriceGoodsDao {

    final List<BrokenPriceGoods> brokenPriceGoodsList = new ArrayList<>();//破价表
    @Value("${CSVPath.BrokenPriceGoods}")
    String csvPath;
    final Map<String,BrokenPriceGoods> pulledBrokenPriceGoodsMap = new HashMap<>();//已经被拉取过的链接
    /**
    * @Description: 加载破价表
    * */
    @PostConstruct
    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvPath),"GBK"));
        CSVFormat csvFormat = CSVFormat.MYSQL.withFirstRecordAsHeader().withSkipHeaderRecord(true);
        CSVParser parser = new CSVParser(reader,csvFormat);
        parser.forEach(csvRecord -> {
            String[] values = csvRecord.get(0).split(",");
            brokenPriceGoodsList.add(
                    new BrokenPriceGoods(){{
                        setId(Integer.valueOf(values[0]));
                        setBatchNo(values[1]);
                        setPlatform(values[2]);
                        setPageUrl(values[3]);
                        setSku_id(values[4]);
                    }}
            );
        });
        parser.close();
        reader.close();
    }


    public List<BrokenPriceGoods> getBrokenPriceGoodsByPlatformAndBatchNoAndCount(String platform, String batchNo, Integer count) {
        synchronized (brokenPriceGoodsList){
            if (platform == null && batchNo == null && count >=0) return null;
            List<BrokenPriceGoods> result = new ArrayList<>(count);
            //从列表中获取链接
            BrokenPriceGoods brokenPriceGoods;
            int i =0;
            while (i < brokenPriceGoodsList.size()){
                brokenPriceGoods = brokenPriceGoodsList.get(i);
                if(Objects.equals(platform, brokenPriceGoods.getPlatform()) && Objects.equals(batchNo,brokenPriceGoods.getBatchNo())){
                    brokenPriceGoodsList.remove(i);
                    pulledBrokenPriceGoodsMap.put(brokenPriceGoods.getSku_id(),brokenPriceGoods);//添加到已被获取的链接列表
                    result.add(brokenPriceGoods);
                    if(--count == 0)return result;
                    continue;
                }
                i++;
            }
            return null;
        }
    }

        /**
        * @Description: 添加破价链接
        * @Param: [brokenPriceGoods：破价信息]
        * @return： boolean
        * @Author: CCYT
        * @Date: 2023/11/23
        */
    public boolean addBrokenPriceGoods(BrokenPriceGoods brokenPriceGoods) {
        return brokenPriceGoodsList.add(brokenPriceGoods);
    }

        /**
         * @Description: 删除已被获取的链接
         * @Param: [sku_id]
         * @return： BrokenPriceGoods:删除的链接
         * @Author: CCYT
         * @Date: 2023/11/23
         */
    public BrokenPriceGoods delPulledBrokenPriceGoods(String sku_id){
        return pulledBrokenPriceGoodsMap.remove(sku_id);
    }


    /**
     * @Description: 将已经获取的链接  重置到未获取的链接列表中(使用synchronized防止在归还的过程中 客户端上传截图导致 链接重复消费
     * @Author: CCYT
     * @Date: 2023/11/23
     */
    public synchronized void PulledBrokenPriceGoodsToBrokenPriceGoods(){
        if(pulledBrokenPriceGoodsMap.size() == 0)return;
        brokenPriceGoodsList.addAll(pulledBrokenPriceGoodsMap.values().stream().toList());
        pulledBrokenPriceGoodsMap.clear();
    }

}
