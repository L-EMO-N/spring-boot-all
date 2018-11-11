package com.profession.modules.community.service.interfaces;

import com.profession.commons.beans.CommunityQueryCriteria;
import com.profession.commons.beans.HotList;

import java.util.List;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
public interface HotListService {
    public List<HotList> queryHotList(CommunityQueryCriteria c);
}
