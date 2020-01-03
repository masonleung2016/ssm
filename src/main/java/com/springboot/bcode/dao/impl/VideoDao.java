package com.springboot.bcode.dao;

import com.springboot.bcode.domain.video.Video;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:32
 * @Package: com.springboot.bcode.dao
 */

public interface VideoDao {
    JqGridPage<Video> selectPage(Video video);

    Video select(Video video);

    int insert(Video video);

    int delete(Video video);



}
