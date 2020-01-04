package com.springboot.bcode.service;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.bcode.domain.video.Video;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:05
 * @Package: com.springboot.bcode.service
 */

public interface VideoService {

    JqGridPage<Video> queryPage(Video video);

    void upload(MultipartFile file);

    void view(String path);

    boolean delete(int id);


}
