package com.demo.mms.service;

import com.demo.mms.common.domain.course;

public interface courseService {
    void addCourse(course course);
    course findcourse(int course_id);
}

