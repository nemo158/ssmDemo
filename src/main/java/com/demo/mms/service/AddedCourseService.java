package com.demo.mms.service;

import com.demo.mms.common.domain.AddedCourse;

public interface AddedCourseService {
    void addNewCourse(AddedCourse addedCourse);

    void deleteCourse(int course_id);
}
