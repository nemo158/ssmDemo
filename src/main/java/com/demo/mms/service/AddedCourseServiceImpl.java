package com.demo.mms.service;

import com.demo.mms.common.domain.AddedCourse;
import com.demo.mms.dao.AddedCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddedCourseServiceImpl implements AddedCourseService{
    @Autowired
    AddedCourseMapper addedCourseMapper;
    @Override
    public void addNewCourse(AddedCourse addedCourse) {
        addedCourseMapper.insertAddedCourse(addedCourse);
    }

    @Override
    public void deleteCourse(int course_id) {
        addedCourseMapper.deleteAddedCourse(course_id);
    }

    @Override
    public AddedCourse findAddedCourse(int course_id) {
        return addedCourseMapper.findAddedCourse(course_id);
    }
}
