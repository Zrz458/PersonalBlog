package com.zrz.zblog.controller.admin;

import com.zrz.zblog.dao.FileDAO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URISyntaxException;

/**
 * @author Rongze Zhao
 * @date 2019-07-30 11:48
 */
@Controller
public class DownloadController {

    @Resource
    private FileDAO fileDAO;

    @GetMapping({"/download/{name}"})
    @ResponseBody
    public ResponseEntity<Object> upload(@PathVariable String name) throws URISyntaxException {
        com.zrz.zblog.entity.File file = fileDAO.findFileByName(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, file.getSize() + "").header("Connection", "close")
                .body(file.getContent().getData());
    }

}