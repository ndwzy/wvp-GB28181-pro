package com.genersoft.iot.vmp.service;

import com.genersoft.iot.vmp.gb28181.bean.DeviceChannel;
import com.genersoft.iot.vmp.gb28181.bean.GbStream;
import com.genersoft.iot.vmp.gb28181.bean.ParentPlatform;
import com.genersoft.iot.vmp.media.zlm.dto.StreamPush;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 级联国标平台关联流业务接口
 */
public interface IGbStreamService {

    /**
     * 分页获取所有
     * @param page
     * @param count
     * @return
     */
    PageInfo<GbStream> getAll(Integer page, Integer count, String platFormId, String catalogId,String query,String mediaServerId);


    /**
     * 移除
     * @param app
     * @param stream
     */
    void del(String app, String stream);

    /**
     * 保存国标关联
     * @param gbStreams
     */
    boolean addPlatformInfo(List<GbStream> gbStreams, String platformId, String catalogId);

    /**
     * 移除国标关联
     * @param gbStreams
     * @param platformId
     */
    boolean delPlatformInfo(String platformId, List<GbStream> gbStreams);

    DeviceChannel getDeviceChannelListByStream(GbStream gbStream, String catalogId, ParentPlatform platform);

    void sendCatalogMsg(GbStream gbStream, String type);
    void sendCatalogMsgs(List<GbStream> gbStreams, String type);

    /**
     * 修改gbId或name
     * @param streamPushItemForUpdate
     * @return
     */
    int updateGbIdOrName(List<StreamPush> streamPushItemForUpdate);

    DeviceChannel getDeviceChannelListByStreamWithStatus(GbStream gbStream, String catalogId, ParentPlatform platform);

    /**
     * 查询所有未分配的通道
     * @param platformId
     * @return
     */
    List<GbStream> getAllGBChannels(String platformId);

    /**
     * 移除所有关联的通道
     * @param platformId
     * @param catalogId
     */
    void delAllPlatformInfo(String platformId, String catalogId);

    List<GbStream> getGbChannelWithGbid(String gbId);

    Map<String, GbStream> getAllGBId();

}
