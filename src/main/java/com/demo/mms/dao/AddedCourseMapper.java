package com.demo.mms.dao;

import com.demo.mms.common.domain.AddedCourse;

public interface AddedCourseMapper {
    void insertAddedCourse(AddedCourse addedCourse);

    void deleteAddedCourse(int course_id);

    AddedCourse findAddedCourse(int course_id);
}
