package org.jnyou.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jnyou.eduservice.entity.EduTeacher;
import org.jnyou.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jnyou
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/eduservice/teacher")
@Api("讲师管理")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询所有讲师  测试整体集成 rest风格
     * @return
     */
    @ApiOperation(value = "查询所有讲师的信息")
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        return teacherService.list(null);
    }

    /**
     * 逻辑删除讲师信息
     * @param id
     * @return
     */
    @ApiOperation(value = "逻辑删除讲师信息")
    @DeleteMapping("{id}")
    public boolean logicDel(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        return teacherService.removeById(id);
    }


}

